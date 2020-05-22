#include <iostream>
#include <vector>
#include <queue>

#define MAX 1001

using namespace std;

int N, M;
int map[MAX][MAX];
int visited[MAX][MAX][2]; // 마지막 2는 벽을 부쉈는지 안부쉈는지

// 동 서 남 북
int dirY[4] = {0, 0, 1, -1};
int dirX[4] = {1, -1, 0, 0};

queue<pair<pair<int, int>, int>> q;

int bfs(int y, int x) {

    q.push(make_pair(make_pair(y, x), 1)); // 시작점,  벽뚫기 가능
    visited[y][x][1] = 1;

    while(!q.empty()){
        int tmpY = q.front().first.first;
        int tmpX = q.front().first.second;
        int block = q.front().second; // 1이면 아직 안뚫은거
        q.pop();

        if (tmpY == N-1 && tmpX == M-1) {
            return visited[tmpY][tmpX][block];
        }

        for (int i=0; i<4; i++) {
            int nextY = tmpY + dirY[i];
            int nextX = tmpX + dirX[i];
            if(0<= nextY && nextY <N && 0<= nextX && nextX <M) {
                if (map[nextY][nextX] == 0) {
                    if (visited[nextY][nextX][block] == 0) { // 벽이 없고, 아직 안갔던 곳
                        q.push(make_pair(make_pair(nextY, nextX), block));
                        visited[nextY][nextX][block] = visited[tmpY][tmpX][block] + 1;
                    } else continue;
                } else {
                    if (block) { // 벽이 있는데, 벽뚫기를 아직 안했을때
                        visited[nextY][nextX][block - 1] = visited[tmpY][tmpX][block] + 1; // visited[nextY][nextX][block - 1] ==> 벽을 뚫은 위치의 방문기록
                        q.push(make_pair(make_pair(nextY, nextX), block-1)); // block-1 ==> 벽 1개 이미 뚫은것
                    }
                }
            }

        }

    }

    return -1;

}



int main(void) {

    cin >> N >> M;
    for (int i=0; i<N; i++) {
        for (int j=0; j<M; j++) {
            int tmp; 
            scanf("%1d", &tmp);
            map[i][j] = tmp;
        }
    }

    cout << bfs(0, 0) << endl;
}