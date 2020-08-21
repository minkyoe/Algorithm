#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#define MAX 21
using namespace std;

int N;
vector<int> num;
int graph[MAX][MAX];
int visited[MAX];
vector<int> selected;
vector<int> notSelected;
int ans = 1000;
int sum = 0;
int visitedSelected[MAX / 2];
vector<int> twoNums;

void perm2(int cnt, vector<int> &num)
{
    if (cnt == 2)
    {
        sum += graph[twoNums[0]][twoNums[1]];
        return;
    }

    for (int i = 0; i < N / 2; i++)
    {
        if (visitedSelected[i])
            continue;
        visitedSelected[i] = true;
        twoNums.push_back(num[i]);
        perm2(cnt + 1, num);
        visitedSelected[i] = false;
        twoNums.pop_back();
    }
}

int getDiff()
{
    perm2(0, selected);
    int sum1 = sum;
    sum = 0;
    memset(visitedSelected, false, sizeof(visitedSelected));
    perm2(0, notSelected);
    int sum2 = sum;
    sum = 0;
    return sum1 > sum2 ? sum1 - sum2 : sum2 - sum1;
}

void perm(int start)
{
    if (selected.size() == N / 2)
    {
        for (int i = 1; i <= N; i++)
        {
            if (!visited[i])
            {
                notSelected.push_back(i);
            }
        }

        int tmp = getDiff();
        ans = ans > tmp ? tmp : ans;

        notSelected.clear();
        return;
    }

    for (int i = start; i <= N; i++)
    {
        if (visited[i])
            continue;
        selected.push_back(i);
        visited[i] = true;
        perm(i + 1);
        visited[i] = false;
        selected.pop_back();
    }
}

int main(void)
{
    cin >> N;
    num = vector<int>(N);
    memset(visited, false, sizeof(visited));
    memset(visitedSelected, false, sizeof(visitedSelected));

    for (int i = 1; i <= N; i++)
    {
        num.push_back(i);
    }

    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= N; j++)
        {
            cin >> graph[i][j];
        }
    }

    perm(1);

    cout << ans;

    return 0;
}