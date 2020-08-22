#include <iostream>
#include <vector>
#include <cstring>
#include <queue>
#include <cmath>

#define MAX 5001

using namespace std;

int tc = 0;
int N = 0;     // 적 숫자
int x, y, R;   // 적 좌표, 진영
int group = 0; // 그룹 수
int visited[MAX];
vector<pair<pair<int, int>, int>> points;

void bfs(int index)
{
    queue<pair<pair<int, int>, int>> q;
    q.push(points[index]);

    while (!q.empty())
    {
        int y = q.front().first.first;
        int x = q.front().first.second;
        int dist = q.front().second;
        q.pop();

        for (int i = 0; i < points.size(); i++)
        {
            int ny = points[i].first.first;
            int nx = points[i].first.second;
            int ndist = points[i].second;
            if (visited[i] == 0)
            {
                if ((ny - y) * (ny - y) + (nx - x) * (nx - x) <= (dist + ndist) * (dist + ndist))
                {
                    q.push(points[i]);
                    visited[i] = 1;
                }
            }
        }
    }
}

int main(void)
{
    cin >> tc;

    while (tc--)
    {
        cin >> N;
        points.clear();
        group = 0;

        for (int i = 0; i < N; i++)
        {
            cin >> x >> y >> R;
            points.push_back({{y, x}, R});
        }

        memset(visited, 0, sizeof(visited)); // 왜 N으로 초기화하면 틀리죠..?
        for (int i = 0; i < points.size(); i++)
        {
            if (visited[i] == 0)
            {
                visited[i] = 1;
                bfs(i);
                group++;
            }
        }

        cout << group << "\n";
    }

    return 0;
}