#include <iostream>
#include <algorithm>
#include <queue>
#define MAX 200001
using namespace std;

// MAX 값 잘 생각하자.......

int N; // 수빈이 위치
int K; // 동생 위치
bool visited[MAX] = {
    false,
};
int ans = 0;

int bfs(int N)
{
    queue<pair<int, int>> q;
    q.push({N, 0});
    int time = 0;

    while (!q.empty())
    {

        int size = q.size();

        for (int i = 0; i < size; i++)
        {
            int now = q.front().first;
            time = q.front().second;
            visited[now] = true;
            q.pop();

            if (now == K)
            {
                return time;
            }

            if (0 <= now - 1 && now - 1 <= MAX && !visited[now - 1])
            {
                q.push({now - 1, time + 1});
                visited[now - 1] = true;
            }
            if (0 <= now + 1 && now + 1 <= MAX && !visited[now + 1])
            {
                q.push({now + 1, time + 1});
                visited[now + 1] = true;
            }
            if (0 <= 2 * now && 2 * now <= MAX && !visited[2 * now])
            {
                q.push({2 * now, time + 1});
                visited[2 * now] = true;
            }
        }
    }
    return time;
}

int main(void)
{
    cin >> N >> K;
    cout << bfs(N);

    return 0;
}