#include <iostream>
#include <cstring>
#include <queue>

using namespace std;

int map[50][50];
int bCnt; // 벌레 개수
int dx[4] = {0, 0, -1, 1};
int dy[4] = {-1, 1, 0, 0};
int T, M, N, K, X, Y;

void BFS(int x, int y) {
    map[x][y] = 0;
    queue<pair<int, int>> q;
    q.push(make_pair(x, y));

    while (!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for (int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (0<= nx && nx < M && 0<= ny && ny < N) {
                if (map[nx][ny]) {
                    map[nx][ny] = 0;
                    q.push(make_pair(nx, ny));
                }
            }
        }

    }

}
int main(void) {

    cin >> T;
    while(T--) {
        cin >> M >> N >> K;
        memset(map, 0, M*N);
        bCnt = 0;

        for (int i=0; i<K; i++) {
            cin >> X >> Y;
            map[X][Y] = 1; // 벌레 있는 곳
        }

        for (int x=0; x<M; x++) {
            for (int y=0; y<N; y++) {
                if (map[x][y]) {
                    BFS(x,y);
                    bCnt++;
                }
            }
        }

        cout << bCnt << endl;
    }

    return 0;
}
