#include <iostream>
#include <queue>
using namespace std;

int N, M;
int map[101][101] = {0,};
int visited[101] = {0,};
int ans;
int MIN = 999999;

queue<int> q;
void ResetVisited() {
    for (int i=1; i<=N; i++) {
        visited[i] = 0;
    }
}

void BFS(int start) {
    visited[start] = 1;
    q.push(start);

    while(!q.empty()) {
        start = q.front();
        q.pop();

        for (int i=1; i<=N; i++) {
            if (map[start][i] == 1 && visited[i] == 0) {
                visited[i] = visited[start] + 1;
                q.push(i);
            }
        }
    }
}
int main(void) {

    cin >> N >> M;

    // 친구관계 맵 초기화
    for (int j=1; j<=M; j++) {
        int x, y;
        cin >> x >> y;
        map[x][y] = 1;
        map[y][x] = 1;
    }

    for (int i=1; i<=N; i++) {
        ResetVisited();
        BFS(i);

        int sum = 0;
        for (int j=1; j<=N; j++) {
            if (i==j) continue;
            else {
                sum += (visited[j]-1); // 처음에 시작위치에서 0아니고 1부터 count해줬으니까 -1 해주기
            }
        }

        if (sum < MIN) {
            MIN = sum;
            ans = i;
        }

    }

    cout << ans;

    return 0;
}