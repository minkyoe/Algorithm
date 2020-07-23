#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

int m[1001][1001];

int main(void){
    
    int n; // 보내려는 이모티콘 개수
    cin >> n; 
    memset(m, -1, sizeof(m)); // -1이면 아직 체크 안한거
    queue<pair<int, int>> q; // 화면, 클립보드 (에 있는 이모티콘 개수)
    q.push(make_pair(1,0)); // 처음에는 화면에 이모티콘 1개 있음
    m[1][0] = 0; // 일단 체크

    while (!q.empty()) {
        int s = q.front().first;
        int c = q.front().second;
        q.pop();

        if (m[s][s] == -1) {
            m[s][s] = m[s][c] + 1; // 화면에 있는 이모티콘 클립보드에 복사할 시 걸리는 시간
            q.push(make_pair(s,s));
        }
        if (s+c <= n && m[s+c][c] == -1) {
            m[s+c][c] = m[s][c] + 1; // 클립 -> 화면 붙여넣기
            q.push(make_pair(s+c,c));
        }
        if (s-1 >= 0 && m[s-1][c] == -1) {
            m[s-1][c] = m[s][c] + 1;
            q.push(make_pair(s-1,c));
        }
    }

    int ans = -1;
    for (int i=0; i<=n; i++) {
        if (m[n][i] != -1) {
            if (ans == -1 || ans > m[n][i]) {
                ans = m[n][i];
            }
        }
    }

    cout << ans << "\n";

    return 0;
}