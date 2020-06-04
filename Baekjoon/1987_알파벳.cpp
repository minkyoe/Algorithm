#include <iostream>
#include <stdio.h>

#define MAX 20
#define AMAX 26

using namespace std;

int R, C; // 세로, 가로
char map[MAX][MAX] = {0,};
bool visited[AMAX] = {false,};
int ans = 1;

// 상 하 좌 우
int dr[4] = {-1, 1, 0, 0};
int dc[4] = {0, 0, -1, 1};

void dfs (int r, int c, int count) {

    for (int i=0; i<4; i++) {
        int nextR = r + dr[i];
        int nextC = c + dc[i];

        if (0<= nextR && nextR <R && 0<= nextC && nextC < C) {
            if (!visited[map[nextR][nextC] - 65]) {
                visited[map[nextR][nextC] - 65] = true;
                dfs(nextR, nextC, count+1);
                visited[map[nextR][nextC] - 65] = false;
            }
        }
    }
    ans = max(ans, count);
    return;
}

int main(void) {

    cin >> R >> C;

    for (int i=0; i<R; i++) {
        for (int j=0; j<C; j++) {
            scanf(" %1c", &map[i][j]);
        }
    }

    visited[map[0][0] - 65] = true;
    dfs(0, 0, 1);
    
    cout << ans << "\n";

    return 0;
}
