#include <iostream>
#include <vector>
#include <queue>
#include <string.h>
using namespace std;

#define MAX 9

int N, M, maxZeroCount, zeroCount;
int map[MAX][MAX];
int tmp[MAX][MAX];
int dR[] = { 1, 0, -1, 0 }; 
int dC[] = { 0, 1, 0, -1 };
queue<pair<int, int>> baseQ, Q;
/**
 * 아.. 뭐야.. 정답만 딱 출력하는거였어 ?? answer:: 3 이런식으로 출력하니까 틀렸대.. 
 * 
 * 
 * **/
int getMax(int n1, int n2) {
    if (n1 >= n2) return n1;
    else return n2;
}

int isInRange(int r, int c) {
    if (r >= 0 && r < N && c >= 0 && c < M) return 1;
    else return 0;
}

void spreadVirus() {
    Q  = baseQ;
    int afterWall[MAX][MAX];
    memcpy(afterWall, tmp, sizeof(tmp));
    int zc = zeroCount;
    
    while (!Q.empty()) { // for (int i=0; i<Q.size(); i++) { ===> Q가 계속변하므로 for문은 부적합함!!
    
        int cr = Q.front().first;
        int cc = Q.front().second;

        Q.pop();
        
        for (int i=0; i<4; i++) {
            // cr += dR[i];
            // cc += dC[i]; // 이런식으로 하면 안됨!! 왜냐면 계속 값이 남아있으니까

            int nR = cr + dR[i];
            int nC = cc + dC[i];
            if (isInRange(nR,nC) == 1 && afterWall[nR][nC] == 0) {
                afterWall[nR][nC] = 2;
                --zc;

                Q.push({nR,nC});
            }
        }   
    }
    

    maxZeroCount = getMax(maxZeroCount, zc);

}


void makeWall(int zCnt) {

    if (zCnt == 3) {
        spreadVirus();
        return;
    }
    for (int i=0; i<N; i++) {
        for (int j=0; j<M; j++) {
            if (tmp[i][j] == 0) {
                tmp[i][j] = 1;
                --zeroCount;
                makeWall(zCnt + 1);
                tmp[i][j] = 0;
                ++zeroCount;
            }
        }
    }
}


int main(void) {

    cin >> N >> M;
    zeroCount = N*M;
    for (int i=0; i<N; i++) {
        for (int j=0; j<M; j++) {
            cin >> map[i][j];

            if (map[i][j] != 0) {
                --zeroCount;
                if (map[i][j] == 2) {
                    baseQ.push(make_pair(i,j));
                }
            }

        }
    }

    for (int i=0; i<N; i++) {
        for (int j=0; j<M; j++) {
            if (map[i][j] == 0) {
                memcpy(tmp, map, sizeof(map));  // 0 발견 시 map copy
                tmp[i][j] = 1;
                --zeroCount;
                makeWall(1);
                tmp[i][j] = 0;
                ++zeroCount;
            }

        }
    }

    cout << maxZeroCount << endl;

    return 0;
}

