#include <iostream>
#include <cstring>
#define MAX 100

int N;
int maxHeight = 0;
int minHeight = 100;
int map[MAX][MAX];
int afterRain[MAX][MAX];
int visited[MAX][MAX];

// 동서남북
int dirY[4] = {0, 0, 1, -1};
int dirX[4] = {1, -1, 0, 0};

int ans = 0; // 물에 잠기지 않은 영역 최대 개수
int cnt = 0;


using namespace std;

void dfs(int y, int x) {

    for (int i=0; i<4; i++) {
        int nextY = y + dirY[i];
        int nextX = x + dirX[i];

        if (0<= nextY && nextY <N && 0<= nextX && nextX <N && !afterRain[nextY][nextX]) {
            if (!visited[nextY][nextX]) {
                visited[nextY][nextX] = 1;
                dfs(nextY, nextX);
            } else continue;
        }
    }
    return;
}

int main(void) {
    cin >> N;

    for (int i=0; i<N; i++) {
        for (int j=0; j<N; j++) {
            cin >> map[i][j];
            maxHeight = maxHeight < map[i][j] ? map[i][j] : maxHeight;
            minHeight = minHeight > map[i][j] ? map[i][j] : minHeight;
        }
    }

    for (int h=0; h<=100; h++) { // h:0 ==> 비가 안올 때도 고려!!
        memset(afterRain, 0, N*N);

        // visited 0으로 초기화
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                visited[i][j] = 0;
            }
        }

        cnt = 0;

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                int tmpH = map[i][j];
                if (tmpH <= h) {
                    afterRain[i][j] = 1;
                } else afterRain[i][j] = 0;
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (afterRain[i][j] == 0 && !visited[i][j]) {
                    visited[i][j] = 1;
                    cnt ++;
                    dfs(i, j);
                }
            }
        }
        ans = ans < cnt ? cnt : ans;
    }

    cout << ans << endl;

}
