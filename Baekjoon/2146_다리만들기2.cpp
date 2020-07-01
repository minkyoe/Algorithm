#include <iostream>
#include <cstring>
#include <vector>
#include <queue>

using namespace std;

int map[100][100];
int dfsVisited[100][100];
int idxVisited[100][100];

int N; // 지도 크기
int minDis; // 최소 거리 (답)

// 상 하 좌 우
int dy[4] = {-1, 1, 0, 0};
int dx[4] = {0, 0, -1, 1};

void DFS (int y, int x, int idx) {

    for (int d=0; d<4; d++) {
        int ny = y + dy[d];
        int nx = x + dx[d];

        if (0<= nx && nx <N && 0<= ny && ny <N) {
            if (map[ny][nx] != 0 && dfsVisited[ny][nx] == 0) {
                dfsVisited[ny][nx] = 1;
                map[ny][nx] = idx;
                DFS(ny, nx, idx);
            }
        }

    }
}

int BFS (int idx) {
    queue<pair<int, int>> idxQ;
    memset(idxVisited, 0, sizeof(idxVisited));

    for (int i=0; i<N; i++) {
        for (int j=0; j<N; j++) {
            if (map[i][j] == idx) {
                idxVisited[i][j] = 1;
                idxQ.push(make_pair(i,j));
            }
        }
    }

    // 외곽점 돌기
    int dis = 0;
    while (!idxQ.empty()) {
        int size = idxQ.size();
        for (int k=0; k<size; k++) {
            int ty = idxQ.front().first;
            int tx = idxQ.front().second;
            idxQ.pop();

            for (int d=0; d<4; d++) {
                int ny = ty + dy[d];
                int nx = tx + dx[d];
                
                if (0<= ny && ny <N && 0<= nx && nx <N) {
                    if (map[ny][nx] != 0 && map[ny][nx] != idx) return dis;
                    if (map[ny][nx] == 0 && idxVisited[ny][nx] == 0) {
                        idxVisited[ny][nx] = 1;
                        idxQ.push(make_pair(ny, nx));
                    }
                }
            }
        }
        dis++;
    }

    return -1;
}

int main(void) {

    cin >> N;
    minDis = N*N;

    for (int i=0; i<N; i++) {
        for (int j=0; j<N; j++) {
            cin >> map[i][j];
        }
    }

    // DFS로 섬 인덱스 붙이기
    int islandIdx = 1;
    for (int i=0; i<N; i++) {
        for (int j=0; j<N; j++) {
            if (map[i][j] == 1 && dfsVisited[i][j] == 0) {
                map[i][j] = islandIdx;
                DFS(i, j, islandIdx);
                islandIdx++;
            } else continue;
        }
    }

    // 섬 인덱스 별로 다리 놓기
    for (int idx=1; idx<islandIdx; idx++) {
        int tmp = BFS(idx);
        minDis = (minDis > tmp) ? tmp : minDis;
    }

    cout << minDis;

    return 0;
} 