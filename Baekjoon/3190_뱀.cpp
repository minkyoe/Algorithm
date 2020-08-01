#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

int N; // 맵 크기
int K; // 사과 개수
int L; // 뱀의 방향 변환 횟수
int dir = 3; // 상하좌우 0123

int dirY[4] = {-1, 1, 0, 0};
int dirX[4] = {0, 0, -1, 1};

char arrL[10001]; // 방향 변환 배열, 인덱스(초) 값(방향)
int map[101][101]; // 0 인덱스 안쓸거임
int ansTime = 0;

queue<pair<int, int>> snake; // 뱀이 있는 좌표들 

int main(void) {
    memset(map, 0, sizeof(map));

    cin >> N;
    cin >> K;
    map[1][1] = 1; // 뱀 1로 표시
    snake.push({1, 1});


    int y = 0;
    int x = 0;
    for (int i = 0; i < K; i++) {
        cin >> y >> x;
        map[y][x] = -1; // 사과 -1로 표시
    }

    cin >> L;
    int t = 0;
    char d;
    for (int i = 0; i < L; i++)
    {
        cin >> t >> d;
        arrL[t] = d;
    }

    int Y = 1;
    int X = 1;

    while (true) {
        ansTime++;

        int ny = Y + dirY[dir];
        int nx = X + dirX[dir];

        // 벽에 부딪히면 끝
        if (nx < 1 || nx > N || ny < 1 || ny > N) break;
        // 자기자신에게 부딪히면 끝
        if (map[ny][nx] == 1) break;

        

        // 이동한 칸에 사과가 있다면
        if (map[ny][nx] == -1) {
            map[ny][nx] = 0; // 사과 먹음
            // cout << "EAT!!!!!!!" << endl;
        }
        else {  // 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
            int tailY = snake.front().first;
            int tailX = snake.front().second;
            // cout << "ny  nx: " << ny <<" " << nx << "  map[ny][nx]  " << map[ny][nx] <<"     time: " << ansTime <<  "  POP  (" << tailY << ", " << tailX  << ")"<< endl;
            map[tailY][tailX] = 0;
            snake.pop();

        }

        // 몸길이 늘려서 머리를 다음칸에 놓음
        map[ny][nx] = 1;
        snake.push({ny, nx});
        

        // 방향 turn
        if (arrL[ansTime] == 'D') {
            if (dir == 0) dir = 3;
            else if (dir == 1) dir = 2;
            else if (dir == 2) dir = 0;
            else if (dir == 3) dir = 1;
        }
        else if (arrL[ansTime] == 'L') {
            if (dir == 0) dir = 2;
            else if (dir == 1) dir = 3;
            else if (dir == 2) dir = 1;
            else if (dir == 3) dir = 0;
        }

        Y = ny;
        X = nx;
        
    }
    
    cout << ansTime;
    
    return 0;
}