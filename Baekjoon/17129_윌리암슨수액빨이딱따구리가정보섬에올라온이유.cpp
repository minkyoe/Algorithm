#include <iostream>
#include <cstring>
#include <queue>
#include <string>

using namespace std;

int map[3000][3000];
int sx, sy; // 시작점
int n, m;
int visited[3000][3000];
int ans;

// 상 하 좌 우
int dy[4] = {-1, 1, 0, 0};
int dx[4] = {0, 0, -1, 1};

int BFS (int sy, int sx) {
    queue<pair<pair<int, int>,int>> q;
    q.push(make_pair(make_pair(sy, sx),0));
    visited[sy][sx] = 1;

    while (!q.empty()) {
        int ty = q.front().first.first;
        int tx = q.front().first.second;
        int dis = q.front().second;

        q.pop();

        if (map[ty][tx] == 3 || map[ty][tx] == 4 || map[ty][tx] == 5) {
            return dis;
        }

        for (int d=0; d<4; d++) {
            int ny = ty + dy[d];
            int nx = tx + dx[d];

            if (0<= nx && nx <m && 0<= ny && ny <n) {
                if (map[ny][nx] != 1 && visited[ny][nx] == 0) {
                    visited[ny][nx] = 1;
                    q.push(make_pair(make_pair(ny, nx), dis+1));
                }
            }
        }
    }
    return -1;
}

int main(void) {
    ios_base :: sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL);

    cin >> n >> m;
    ans = n*m;
    memset(visited, 0, n*m);

    for (int i=0; i<n; i++) {
        string str;
        cin >> str;
        for (int j=0; j<m; j++) {
            map[i][j] = stoi(str.substr(j,1));
            if (map[i][j] == 2) {
                sy = i;
                sx = j;
            }
        }
    }
    
    int tmp = BFS(sy, sx);
    if (tmp == -1) cout << "NIE" << "\n";
    else {
        cout << "TAK" << "\n";
        cout << tmp << "\n";
    }

    return 0;
} 

