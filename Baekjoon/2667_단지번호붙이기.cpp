#include <queue>
#include <vector>
#include <iostream>
#include <stdio.h>
#include <algorithm>

using namespace std;

int map[25][25];
int visited[25][25];
int N;
int cnt; // 단지 번호
int hCnt; // 단지 내 집 개수
vector<int> house; // 집 개수 정렬할 벡터

int dirY[4] = {-1, 1, 0, 0};
int dirX[4] = {0, 0, -1, 1};

int bfs(int y, int x, int cnt) {
    int houseCnt = 0; // return 해줘야 할 단지 내 집 개수
    map[y][x] = cnt;
    queue<pair<int, int>> q;
    q.push(make_pair(y, x)); houseCnt ++;

    while (!q.empty()) {
        int ty = q.front().first;
        int tx = q.front().second;
        q.pop();

        for (int i=0; i<4; i++) {
            int ny = ty + dirY[i];
            int nx = tx + dirX[i];

            if (0<= ny && ny <N && 0<= nx && nx <N) {
                if (map[ny][nx] == 1 && visited[ny][nx] == 0) {
                    map[ny][nx] = cnt;
                    visited[ny][nx] = 1;
                    q.push(make_pair(ny, nx)); houseCnt ++;
                }
            }
        }
    }
    return houseCnt;
}

int main(void) {
    cin >> N;
    for (int i=0; i<N; i++) {
        for (int j=0; j<N; j++) {
            scanf(" %1d", &map[i][j]);
        }
    }

    cnt = 0;
    for (int i=0; i<N; i++) {
        for (int j=0; j<N; j++) {
            if (map[i][j] == 1 && visited[i][j] == 0) {
                visited[i][j] = 1;
                hCnt = bfs(i, j, ++cnt);
                house.push_back(hCnt);
            }
        }
    } 
    sort(house.begin(), house.end(), less<int>());

    cout << cnt << endl;
    for (int i=0; i<house.size(); i++) {
        cout << house[i] << endl;
    }

    return 0;
}

