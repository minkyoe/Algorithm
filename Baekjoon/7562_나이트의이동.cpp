#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

int N; // 체스판 크기 n X n
int map[300][300];
int ty, tx, ly, lx; // 현재 위치, 이동하려는 위치
int ans;

// 나이트가 이동할 수 있는 방향 (좌상, 우상, 우하, 좌하 -> 시계방향순)
int dy[8] = {-1, -2, -2, -1, 1, 2, 2, 1};
int dx[8] = {-2, -1, 1, 2, 2, 1, -1, -2};

void bfs (int y, int x, int cnt) {
    queue<pair<pair<int, int>,int>> q;
    q.push(make_pair(make_pair(y, x),0));

    while (!q.empty()) {
        int ty = q.front().first.first;
        int tx = q.front().first.second;
        int space = q.front().second;
        q.pop();

        if (ty == ly && tx == lx) {
            ans = space;
            return;
        }

        for (int d=0; d<8; d++) {
            int ny = ty + dy[d];
            int nx = tx + dx[d];

            if (0<= ny && ny <N && 0<= nx && nx <N) {
                if (map[ny][nx] == 0) {
                    map[ny][nx] = space + 1;
                    q.push(make_pair(make_pair(ny, nx),space+1));
                }
            }

        }
    }
}

int main(void){
    int tc = 0;
    cin >> tc;
    while (tc--) {
        cin >> N; // 너비, 높이
        cin >> ty >> tx;
        cin >> ly >> lx;

        memset(map, 0, sizeof(map));

        bfs(ty, tx, 0);

        cout << ans << endl;
    }
   

    return 0;
}