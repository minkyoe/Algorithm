#include <iostream>
#define INF 100001
using namespace std;

int V;
int E;
int map[401][401];
int ans = INF;

int main(void)
{
    cin >> V >> E;

    for (int i = 1; i <= V; i++)
    {
        for (int j = 1; j <= V; j++)
        {
            if (i == j)
            {
                map[i][j] = 0;
                continue;
            }
            map[i][j] = INF;
        }
    }

    int v1;
    int v2;
    int e;
    for (int i = 0; i < E; i++)
    {
        cin >> v1 >> v2 >> e;
        map[v1][v2] = e;
    }

    // 거쳐가는 정점 k
    for (int k = 1; k <= V; k++)
    {
        for (int i = 1; i <= V; i++)
        {
            for (int j = 1; j <= V; j++)
            {
                if (i == k || j == k || i == j)
                    continue;
                if (map[i][j] > map[i][k] + map[k][j])
                {
                    map[i][j] = map[i][k] + map[k][j];
                }
            }

        } // end of second for

    } // end of third for

    for (int i = 1; i <= V; i++)
    {
        for (int j = 1; j <= V; j++)
        {
            if (map[i][j] == 0)
                continue;
            ans = (ans > map[i][j] + map[j][i]) ? map[i][j] + map[j][i] : ans;
        }
    }

    if (ans == INF)
        cout << "-1";
    else
        cout << ans;

    return 0;
}