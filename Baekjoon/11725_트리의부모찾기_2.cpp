#include <iostream>
#include <vector>
#define MAX 100000
using namespace std;

int parents[MAX+1];
vector<int> adjList[MAX+1];
bool visited[MAX+1];
int N; // 노드 개수

void find(int now) {
    visited[now] = true;

    for (int i = 0; i < adjList[now].size(); i++)
    {
        int next = adjList[now][i];
        if (visited[next]) continue;
        visited[next] = true;
        parents[next] = now;
        find(next);
    }
    
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;

    int a;
    int b;

    for (int i = 1; i < N; i++)
    {
        cin >> a >> b;
        adjList[a].push_back(b);
        adjList[b].push_back(a);
    }

    find(1);

     for (int i = 2; i <= N; i++)
    {
        cout << parents[i] << "\n";
    }

    return 0;
}