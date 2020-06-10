#include <iostream>

#define PMAX 12
using namespace std;

int tc;
bool visited[PMAX];
int map[PMAX][PMAX];
int ans;

void DFS(int d, int sum) {
    if (d == 12) {
        ans = ans < sum ? sum : ans;
        return;
    }

    for (int i=1; i<=11; i++) {
        if (visited[i] || !map[d][i]) continue;
        else {
            visited[i] = true;
            DFS(d + 1, sum + map[d][i]);
            visited[i] = false;
        }
    }
}

int main(void) {

    cin >> tc;

    while (tc--) {
        ans = 0;
        for (int i=1; i<=11; i++) {
            visited[i] = false;
            for (int j=1; j<=11; j++) {
                cin >> map[i][j];
            }
        }
        DFS(1, 0);
        cout << ans << endl;        
    }
  
    return 0;
}
