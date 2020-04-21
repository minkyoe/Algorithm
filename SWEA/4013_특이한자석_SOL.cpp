#include <iostream>
#include <queue>
#define MAG_COUNT 4
#define WHEEL_COUNT 8
using namespace std;

int arrCopy[MAG_COUNT][WHEEL_COUNT] = {};
int magWheel[MAG_COUNT][WHEEL_COUNT] = {}; // 각 자석의 날 자성정보. N극 = 0, S극 = 1. 시계방향 순
int rotationInfo[20][2] = {}; // 1 <= K <= 20 이므로.
int answer = 0;
int visited[MAG_COUNT] = {0,};

void rotate(int idx, int dir) {

    visited[idx] = 1;

    // 현재 자석 배열 copy
    int copy[1][8] = {};
    for (int i=0; i<WHEEL_COUNT; i++) {
        copy[0][i] = magWheel[idx][i];
    }

    // 방향에 맞게 한칸씩 옮기기
    for (int j=0; j<WHEEL_COUNT; j++) {
        if (dir == 1) magWheel[idx][(j+1)%WHEEL_COUNT] = copy[0][j%WHEEL_COUNT];
        if (dir == -1) magWheel[idx][(WHEEL_COUNT-j)%WHEEL_COUNT] = copy[0][(WHEEL_COUNT-j+1)%WHEEL_COUNT];
    }
    
}

void dfs(int idx, int dir) {

        rotate(idx, dir);

        for (int mag=0; mag<2; mag++) { // 양옆 두번
            if (0<= idx-1 && !visited[idx-1]) { // 지금 자석보다 앞에 있는 자석이 있고 방문한적없다면
                if (arrCopy[idx-1][2] != arrCopy[idx][6]) dfs(idx-1, dir*-1); // 맞물리는 부분의 극이 다른지 비교해서 다르면
            }
            if (idx+1 < 4 && !visited[idx+1]) { // 지금 자석보다 뒤에 있는 자석이 있다면
                if (arrCopy[idx+1][6] != arrCopy[idx][2]) dfs(idx+1, dir*-1); // 맞물리는 부분의 극이 다른지 비교해서 다르면
            } 
        }
    
}


void getAnswer() {
    if (magWheel[0][0] == 1) answer += 1;
    if (magWheel[1][0] == 1) answer += 2;
    if (magWheel[2][0] == 1) answer += 4;
    if (magWheel[3][0] == 1) answer += 8;
}

int main(void) {

    int K = 0; // 자석을 회전시키는 횟수. 1 이상 20이하

    cin >> K ;

    for (int i=0; i<MAG_COUNT; i++) {
        for (int j=0; j<WHEEL_COUNT; j++) {
            cin >> magWheel[i][j];
        }
    }

    for (int k=0; k<K; k++) {
        for (int j=0; j<2; j++) {
            cin >> rotationInfo[k][j];
        }
    }

     // 자석 배열 copy
        for (int i=0; i<MAG_COUNT; i++) {
            for (int j=0; j<WHEEL_COUNT; j++) {
                arrCopy[i][j] = magWheel[i][j];
            }
        }  

    for (int rcnt=0; rcnt<K; rcnt++) {
        int rmag = rotationInfo[rcnt][0]; // 회전시켜야 할 자석
        int rdir = rotationInfo[rcnt][1]; // 회전시킬 방향. 1=시계방향, -1=반시계방향

        visited[rmag-1] = 1;
       dfs(rmag-1, rdir);
           
        // 자석 배열 copy
        for (int i=0; i<MAG_COUNT; i++) {
            for (int j=0; j<WHEEL_COUNT; j++) {
                arrCopy[i][j] = magWheel[i][j];
            }
        }  

        // visited 초기화
        for (int i=0; i<MAG_COUNT; i++) {
            visited[i] = 0;
        }
    }

    getAnswer();

    cout << "answer:: " << answer;
    
    return 0;
}

