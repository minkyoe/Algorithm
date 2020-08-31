#include <iostream>
#include <queue>
#define HMAX 16
using namespace std;

int dy[] = {0, 1, 1};
int dx[] = {1, 0, 1};
int map[HMAX + 1][HMAX + 1];
int cnt = 0;
int N;

void bfs(int y, int x, int m)
{
    queue<pair<pair<int, int>, int>> q;
    q.push(make_pair(make_pair(y, x), m));

    while (!q.empty())
    {
        int fy = q.front().first.first;
        int fx = q.front().first.second;
        int mode = q.front().second;
        q.pop();

        if (fy == N && fx == N)
        {
            ++cnt;
            continue;  // 이미 도착지점에 도달했으므로 더 탐색할 필요 없음
        }

        for (int i = 0; i < 3; i++)
        { // 0: 가로, 1: 세로, 2: 대각선
            if ((i == 0 && mode == 1) || (i == 1 && mode == 0)) continue; 

            int ny = fy + dy[i];
            int nx = fx + dx[i];

            if (ny > N || nx > N || map[ny][nx] == 1) continue;

            if (i == 2)
            {
                if (nx - 1 < 1 || map[ny][nx - 1] == 1 || map[ny - 1][nx] == 1) 
                    continue;
            }
            q.push(make_pair(make_pair(ny, nx), i));
        }
    }

    return;
}
int main(void)
{

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;

    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= N; j++)
        {
            cin >> map[i][j];
        }
    }

    bfs(1, 2, 0);

    cout << cnt;
    return 0;
}