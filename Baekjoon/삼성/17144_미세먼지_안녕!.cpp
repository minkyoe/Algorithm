#include <iostream>
#include <queue>
#define MAX 50
using namespace std;


int answer = 0;
int R, C, T = 0;
int room[MAX][MAX];
int roomCopy[MAX][MAX];
queue<pair<int, int>> q; // 미세먼지 있는 곳만 저장


// 공기청정기 위치 , [0] -> 첫번째 공기청정기 ,, [1] -> 두번째 공기청정기 
int cleanY[2] = {-1 ,-1};
int cleanX[2] = {-1 ,-1};

int spreadY[4] = {-1, 0, 0, 1};
int spreadX[4] = {0, -1, 1, 0};

// 시계방향 
int clockDirY[4] = {0, 1, 0, -1};
int clockDirX[4] = {1, 0, -1, 0};

// 반시계방향 
int reclockDirY[4] = {0, -1, 0, 1};
int reclockDirX[4] = {1, 0, -1, 0};



void spreadMiMun() {
    while(!q.empty()) {
        int Y = q.front().first;
        int X = q.front().second;
        q.pop();

        int tmpY = 0;
        int tmpX = 0;

        for (int i=0; i<4; i++) {
            tmpY = Y + spreadY[i];
            tmpX = X + spreadX[i];

            if (0<= tmpY && tmpY <R && 0<= tmpX && tmpX <C) {
                if (roomCopy[tmpY][tmpX] >= 0) {
                    room[tmpY][tmpX] += roomCopy[Y][X] / 5;   
                    room[Y][X] -= roomCopy[Y][X] / 5;
                }
            }
        }
    }
}

void goCleanMachine() {

    // 위쪽 공기 청정기 
    // 원래 위치
    int Y = cleanY[0];
    int X = cleanX[0] + 1; // 공기청정기 옆부터 시작
    room[Y][X] = 0; // 어차피 범위 밖이거나 공기청정기 만나도 0이 됨 (옮겨갈수 있는 위치라면 당연히 원래자리는 0이 되고 옮겨갈 위치에 값이 쓰여짐)

        for (int j=0; j<4; j++) { // 4가지 방향
            while (1) {

                int tmpY = 0;
                int tmpX = 0;
                
                // 옮겨가야할 위치
                tmpY = Y + reclockDirY[j];
                tmpX = X + reclockDirX[j];

                if (!(0<= tmpY && tmpY <R && 0<= tmpX && tmpX <C)) break;
                if (tmpY == cleanY[0] && tmpX == cleanX[0]) break;
                
                room[tmpY][tmpX] = roomCopy[Y][X];
            
                Y = tmpY;
                X = tmpX;
            }
        }


        // 아래쪽 공기 청정기
        // 원래 위치
        int Y2 = cleanY[1];
        int X2 = cleanX[1] + 1;
        room[Y2][X2] = 0;

        for (int j=0; j<4; j++) { // 4가지 방향
            while (1) {
               
                int tmpY = 0;
                int tmpX = 0;

                // 위쪽 공기청정기
                tmpY = Y2 + clockDirY[j];
                tmpX = X2 + clockDirX[j];

                if (!(0<= tmpY && tmpY <R && 0<= tmpX && tmpX <C)) break; 
                if (tmpY == cleanY[1] && tmpX == cleanX[1]) break;
                
                room[tmpY][tmpX] = roomCopy[Y2][X2];
               
                Y2 = tmpY;
                X2 = tmpX;
            }
        }

    
    
}

int main(void) {

    cin >> R >> C >> T;

    for (int i=0; i<R; i++) {
        for (int j=0; j<C; j++) {
            cin >> room[i][j];
            
            // 공기청정기 위치 저장
            if (room[i][j] == -1) {
                if (cleanY[0] == -1 && cleanX[0] == -1) {
                    cleanY[0] = i;
                    cleanX[0] = j;
                } else {
                    cleanY[1] = i;
                    cleanX[1] = j;
                }
            }


        }
    }


    for (int t=0; t<T; t++) {
        // 미세먼지 있는 곳 저장
        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (room[i][j] > 0) {
                    q.push({i, j});
                }
            }
        }
            

        // 방 배열 복사
        for (int i=0; i<R; i++) {
             for (int j=0; j<C; j++) {
                roomCopy[i][j] = room[i][j];
             }
        }
           

        // 미세먼지 확산
        spreadMiMun();


        // 미세먼지 확산 된 배열 복사
        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                roomCopy[i][j] = room[i][j];
            }
        }  
        // cout << "확 산 후 ~~~~~~~~~~~~~" << endl;
        // for (int i=0; i<R; i++) {
        //     for (int j=0; j<C; j++) {
        //         cout << room[i][j] << " ";
        //     }
        //     cout << endl;
        // }

        //     cout << endl;
        //     cout << endl;
        //     cout << endl;

                    
        // 공기청정기 방향대로 순환
        goCleanMachine();

        // 방 배열 복사 
        for (int a=0; a<R; a++) {
            for (int b=0; b<C; b++) {
                roomCopy[a][b] = room[a][b];
            }
        }

        // cout << "순환 후 ~~~~~~~~~~~~~~" << endl;
        // for (int i=0; i<R; i++) {
        //     for (int j=0; j<C; j++) {
        //         cout << room[i][j] << " ";
        //     }
        //     cout << endl;
        // }

        //     cout << endl;
        //     cout << endl;
        //     cout << endl;



        if (t == T-1) {
        // 정답 세고 출력
            for (int i=0; i<R; i++) {
                for (int j=0; j<C; j++) {
                    if (room[i][j] > 0)
                        answer += room[i][j];
                }
            }

            cout << answer << endl;

        }
       
    }

        
    return 0;
}

