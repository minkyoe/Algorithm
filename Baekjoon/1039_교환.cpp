#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <queue>
#include <set>

using namespace std;

int N, len, K;

void BFS(string S) {
    queue<string> Q;
    Q.push(S);

    int cnt = 0;
    int ans = 0;

    while (!Q.empty() && cnt < K) {
        int size = Q.size();
        set<string> visited;

        // cnt = i일때 i번 바뀐 수들이 Q에 저장되어 있음
        // 모든 i번 바뀐 수들을 한번씩 더 바꿔봄
        for (int q=0; q<size; q++) {
            string now = Q.front();
            Q.pop();

            // 숫자 바꿔보기
            for (int i=0; i<len-1; i++) {
                for (int j=i+1; j<len; j++) {
                    if (i == 0 && now[j] == '0') continue;

                    swap(now[i], now[j]);

                    if (!visited.count(now)) {
                        if (cnt == K-1) ans = ans < stoi(now) ? stoi(now) : ans;
                        Q.push(now);
                        visited.insert(now);
                    }
                    swap(now[i], now[j]);
                }
            }
        }
        cnt ++;
    }
    if (cnt!=K) cout << -1 << endl;
    else cout << ans << endl;
    
}

int main(void) {

    string tmp;
    cin >> tmp >> K;
    N = stoi(tmp);
    len = tmp.size();

    if (len == 1 || (len == 2 && tmp[len-1] == '0')) cout << -1 << endl;	
    else BFS(tmp);  
  
    return 0;
}
