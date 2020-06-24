#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

vector<int> num;
int visited[101][101] = {0,};
long long ans = 0; // int 노노!!!

void GCD(int a, int b) {
    while (b != 0) {
        int r = a % b;
        a = b;
        b = r;
    }
    ans += a;
}

int main(void) {
    int a, b;
    int n, m;
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> m;

        num = vector<int> (m);
        memset(visited, 0, 101*101);
        ans = 0;

        for (int j = 0; j < m; j++) {
            cin >> num[j];
        }

        for (int a = 0; a < m; a++) {
            for (int b = 0; b < m; b++) {
                if (visited[a][b] || visited[b][a] || a==b) continue;
                else {
                    GCD(num[a], num[b]);
                    visited[a][b] = 1;
                    visited[b][a] = 1;
                }
            }
        }
        cout << ans << endl;
    }
}