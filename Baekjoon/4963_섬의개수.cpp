#include <iostream>
#include <queue>

using namespace std;

int w, h; // 너비, 높이
int map[50][50];
int numbered[50][50];

int dy[8] = {-1, 1, 0, 0, -1, -1, 1, 1};
int dx[8] = {0, 0, -1, 1, -1, 1, 1, -1};

void bfs (int y, int x, int cnt) {
    queue<pair<int, int>> q;
    q.push(make_pair(y, x));
    numbered[y][x] = cnt;

    while (!q.empty()) {
        int ty = q.front().first;
        int tx = q.front().second;
        q.pop();

        for (int d=0; d<8; d++) {
            int ny = ty + dy[d];
            int nx = tx + dx[d];

            if (0<= ny && ny < h && 0<= nx && nx <w) {
                if (numbered[ny][nx] == 0 && map[ny][nx] == 1) {
                    numbered[ny][nx] = cnt;
                    q.push(make_pair(ny,nx));
                }
            }

        }
    }
}

int main(void){
    while (true) {
        cin >> w >> h; // 너비, 높이

        if (w == 0 && h == 0) break;

        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                cin >> map[i][j];
                numbered[i][j] = 0;
            }
        }

        int cnt = 0;
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                if (map[i][j] == 1 && numbered[i][j] == 0) {
                    bfs(i, j, ++cnt);
                }
            }
        }
        cout << cnt << endl;
    }
   

    return 0;
}