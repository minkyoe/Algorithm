#include <iostream>
#include <queue>

using namespace std;

int N, M;
int ans = 0;
int map[1000][1000];
int day[1000][1000];

int dy[4] = {-1, 1, 0, 0};
int dx[4] = {0, 0, -1, 1};

queue<pair<int, int>> q;
void bfs () {
    while (!q.empty()) {
        int ty = q.front().first;
        int tx = q.front().second;
        q.pop();

        for (int d=0; d<4; d++) {
            int ny = ty + dy[d];
            int nx = tx + dx[d];

            if (0<= ny && ny < N && 0<= nx && nx <M) {
                if (day[ny][nx] == -1 && map[ny][nx] == 0) {
                    day[ny][nx] = day[ty][tx] + 1;
                    ans = (ans < day[ny][nx]) ? day[ny][nx] : ans;
                    q.push(make_pair(ny,nx));
                }
            }

        }
    }
}

int main(void){
    cin >> M >> N; // 가로, 세로

    for (int i=0; i<N; i++) {
        for (int j=0; j<M; j++) {
            cin >> map[i][j];
            day[i][j] = -1;
            if (map[i][j] == 1) {
                day[i][j] = 0;
                q.push(make_pair(i,j));
            }
        }
    }

    bfs();
   
    for (int i=0; i<N; i++) {
        for (int j=0; j<M; j++) {
            if (map[i][j] == 0 && day[i][j] == -1) {
                ans = -1;
            }
        }
    }
    
    cout << ans;

    return 0;
}