#include <iostream>
#include <vector>
#include <cmath>
#include <queue>
#define DMAX 10
using namespace std;

int N;
int people[DMAX + 1];
int selected[DMAX + 1];
vector<vector<int>> list;
int ans = 1000; // 최대 900, 최소 1
vector<int> district1;
vector<int> district2;

bool findNext(int idx, int target)
{
    if (idx == 1)
    {
        for (int i = 0; i < district2.size(); i++)
        {
            if (target == district2[i]) return true;
        }
        return false;
    }
    else
    {
        for (int i = 0; i < district1.size(); i++)
        {
            if (target == district1[i]) return true;
        }
        return false;
    }
}
bool check(vector<int> &district, int disIdx)
{
    bool visited[DMAX + 1] = {0,}; // 0 인덱스 안씀

    queue<int> q;
    q.push(district[0]);
    visited[district[0]] = true;

    while (!q.empty())
    {
        int now = q.front();
        q.pop();

        for (int i = 0; i < list[now - 1].size(); i++)
        {
            int next = list[now - 1][i];
            if (visited[next]) continue;
            if (findNext(disIdx, next)) continue;

            q.push(next);
            visited[next] = true;
        }
    }

    for (int i = 0; i < district.size(); i++)
    {
        if (!visited[district[i]]) return false;
    }

    return true;
}

void go(int idx, int cnt)
{
    if (cnt > 0)
    {
        district1.clear();
        district2.clear();

        for (int i = 1; i <= N; i++)
        {
            if (selected[i]) district1.push_back(i);
            else district2.push_back(i);
        }

        if (district1.size() > 0 && district2.size() > 0 && check(district1, 1) && check(district2, 2))
        {
            int sum1 = 0;
            for (int i = 0; i < district1.size(); i++)
            {
                int dis = district1[i];
                sum1 += people[dis];
            }

            int sum2 = 0;
            for (int i = 0; i < district2.size(); i++)
            {
                int dis = district2[i];
                sum2 += people[dis];
            }

            int diff = abs(sum1 - sum2);
            ans = ans > diff ? diff : ans;
        }
    }

    for (int i = idx; i <= N; i++)
    {
        if (selected[i]) continue;
        selected[i] = true;
        go(idx + 1, cnt + 1);
        selected[i] = false;
    }
}

int main(void)
{

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    for (int i = 1; i <= N; i++)
    {
        cin >> people[i];
    }

    for (int i = 0; i < N; i++)
    {
        int cnt = 0;
        cin >> cnt;
        vector<int> tmp;
        for (int j = 0; j < cnt; j++)
        {
            int n = 0;
            cin >> n;
            tmp.push_back(n);
        }
        list.push_back(tmp);
    }

    go(1, 0); // idx, cnt

    if (ans == 1000) ans = -1;
    cout << ans;

    return 0;
}