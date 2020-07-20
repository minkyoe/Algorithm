#include <iostream>
#include <stdio.h>
#include <queue>

using namespace std;

int N, M;
int map[101][101];
int visited[101][101];

int dy[4] = {-1, 1, 0, 0};
int dx[4] = {0, 0, -1, 1};
int ans = 0;

void bfs (int i, int j) {
    queue<pair<pair<int, int>, int>> q;
    q.push(make_pair(make_pair(i,j), 0));

    while (!q.empty()) {
        int ty = q.front().first.first;
        int tx = q.front().first.second;
        int dis = q.front().second;
        q.pop();

        if (ty == N && tx == M) {
            ans = dis + 1;
            return;
        }

        for (int d=0; d<4; d++) {
            int ny = ty + dy[d];
            int nx = tx + dx[d];

            if (1<= ny && ny <= N && 1<= nx && nx <=M) {
                if (visited[ny][nx] == 0 && map[ny][nx] == 1) {
                    visited[ny][nx] = 1;
                    q.push(make_pair(make_pair(ny,nx), dis+1));
                }
            }

        }
    }
}

int main(void){
    cin >> N >> M;

    for (int i=1; i<=N; i++) {
        for (int j=1; j<=M; j++) {
            scanf(" %1d", &map[i][j]);
        }
    }
    
    visited[1][1] = 1;
    bfs(1,1);

    cout << ans;

    return 0;
}