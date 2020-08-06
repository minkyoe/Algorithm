#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

int n; // 동기 수
int m;
int ans = 0;
bool visited[501];
bool isFriend[501][501];
vector<int> friends;

int main(void)
{
    memset(visited, false, sizeof(visited));
    memset(isFriend, false, sizeof(isFriend));

    cin >> n;
    cin >> m;
    int n1, n2;
    for (int i = 0; i < m; i++)
    {
        cin >> n1 >> n2;
        isFriend[n1][n2] = isFriend[n2][n1] = true;
    }

    for (int i = 2; i <= n; i++)
    {
        if (isFriend[1][i])
        {
            ++ans;
            visited[i] = true;
            friends.push_back(i);
        }
    }

    // 친구의 친구 구하기
    for (int i = 0; i < friends.size(); i++)
    {
        int nowFriend = friends[i];
        for (int i = 2; i <= n; i++)
        {
            if (isFriend[nowFriend][i] && !visited[i])
            {
                visited[i] = true;
                ++ans;
            }
        }
    }

    cout << ans;

    return 0;
}