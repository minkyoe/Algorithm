#include <string>
#include <iostream>
#include <vector>
using namespace std;

int tc, V, E;
int color[20001]; // 0: 방문안함, 1: 그룹A, 2: 그룹B
vector<int> v[20001]; // 2차원배열(인접행렬)로 풀었더니 메모리초과.. 인접리스트로 변경!
bool isOK;

void dfs(int node, int c) {
    color[node] = c;
    for (int j=0; j<v[node].size(); j++) {
        if (color[v[node][j]] == 0) {
            dfs(v[node][j], 3-c);
        }
    }
}

int main (void) {

    cin >> tc;

    while (tc--) {
        cin >> V >> E; // 정점 개수, 간선 개수
        isOK = true;

        for (int i=1; i<=V; i++) {
            v[i].clear();
            color[i] = 0;
        }

        for (int i=0; i<E; i++) {
            int node1, node2;
            cin >> node1 >> node2;
            v[node1].push_back(node2);
            v[node2].push_back(node1);
        }

        for (int i=1; i<=V; i++) {
            if (color[i] == 0) {
                dfs(i, 1);
            }
        }

        for (int i=1; i<=V; i++) {
            for (int j=0; j<v[i].size(); j++) {
                if (color[i] == color[v[i][j]]) isOK = false;
            }
        }

        if (isOK) cout << "YES" << "\n";
        else cout << "NO" << "\n";

    }

    return 0;
}