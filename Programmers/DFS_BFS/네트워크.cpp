#include <string>
#include <vector>
#include <iostream>

using namespace std;

int answer = 0;
int visited[201];

void dfs(int start, vector<vector<int>> computers, int n)
{
    visited[start] = 1;
    for (int i = 0; i < n; i++)
    {
        if (!visited[i] && computers[start][i] == 1) {
            dfs(i, computers, n);
        }
    }
}

int solution(int n, vector<vector<int>> computers)
{
    for (int i = 0; i < n; i++)
    {
        if (!visited[i]) {
            answer++;  
            dfs(i, computers, n);
        }
    }
    return answer;
}

int main(void)
{

    solution(3, {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}});
    cout << "answer:: " << answer <<endl;
    return 0;
}