#include <iostream>
#include <vector>
#define MAX 10
using namespace std;

int map[MAX][MAX];
int paper[6];  // 0번인덱스 안씀
int ans = MAX*MAX; // 모든 1을 덮는데 필요한 색종이의 최소 개수, 비교를 위해 최대값으로 초기화

bool isPossible(int r, int c, int size)
{
    if (r + size > MAX || c + size > MAX) return false;
    for (int y = r; y < r + size; y++)
    {
        for (int x = c; x < c + size; x++)
        {
            if (map[y][x] == 0) return false;
        }
    }
    return true;
}
void dfs(int y, int x, int cnt)
{

    if (y == MAX)
    {
        ans = ans > cnt ? cnt : ans;
        return;
    }
    if (x == MAX)
    {   
        dfs(y + 1, 0, cnt);
        return;
    }
    if (cnt >= ans) return;

    if (map[y][x] == 1)
    {
        for (int i = 5; i >= 1; i--)
        {
            if (paper[i] > 0 && isPossible(y, x, i))
            {
                int size = i;
                bool flag = isPossible(y, x, size);
                // 색종이 붙임
                for (int r = y; r < y + size; r++)
                {
                    for (int c = x; c < x + size; c++)
                    {
                        map[r][c] = 0;
                    }
                }
                // 색종이 수 감소
                paper[i] -= 1;

                dfs(y, x + size, cnt + 1);

                // 색종이 수 증가
                paper[i] += 1;
                // 색종이 다시 떼기
                for (int r = y; r < y + size; r++)
                {
                    for (int c = x; c < x + size; c++)
                    {
                        map[r][c] = 1;
                    }
                }
            }
        }
    }
    else
    {
        dfs(y, x + 1, cnt);
    }

    return;
}
int main(void)
{

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    for (int i = 0; i < MAX; i++)
    {
        for (int j = 0; j < MAX; j++)
        {
            cin >> map[i][j];
        }
    }

    for (int i = 0; i < 6; i++)
    {
        paper[i] = 5;
    }

    dfs(0, 0, 0); // 좌표, 사용한 색종이 개수

    if (ans == MAX*MAX)
        ans = -1;
    cout << ans;

    return 0;
}