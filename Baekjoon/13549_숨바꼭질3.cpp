#include <iostream>
#include <algorithm>
#include <deque>
#define MAX 200001
using namespace std;

// 가중치가 다른 BFS -> Queue 2개 사용 OR Deque이용

int N; // 수빈이 위치
int K; // 동생 위치
bool visited[MAX] = {
    false,
};
int ans = 0;

int bfs(int N)
{
    deque<pair<int, int>> q;
    q.push_back({N, 0});
    int time = 0;

    while (!q.empty())
    {

        int size = q.size();

        for (int i = 0; i < size; i++)
        {
            int now = q.front().first;
            time = q.front().second;
            visited[now] = true;
            q.pop_front();

            if (now == K)
            {
                return time;
            }

            if (0 <= 2 * now && 2 * now <= MAX && !visited[2 * now])
            {
                q.push_front({2 * now, time});
                visited[2 * now] = true;
            }
            if (0 <= now - 1 && now - 1 <= MAX && !visited[now - 1])
            {
                q.push_back({now - 1, time + 1});
                visited[now - 1] = true;
            }
            if (0 <= now + 1 && now + 1 <= MAX && !visited[now + 1])
            {
                q.push_back({now + 1, time + 1});
                visited[now + 1] = true;
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