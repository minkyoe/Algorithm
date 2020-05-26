#include <iostream>
#include <vector>
#define NMAX 901
using namespace std;

// K N F -> N명 중 K명 선발
int K, N, F;
bool relation[NMAX][NMAX];
int visited[NMAX] = {0,};
bool isEnded = false;

bool isAllFriend(int num) {
    for (int i=1; i<=N; i++) {
        if (visited[i]) {
            if (!relation[i][num]) return false;
        }
        continue;
    }
    return true;
}

void dfs(int num, int cnt) {
    if (isEnded) return;
    if (cnt == K) {
        isEnded = true;
        for (int k=1; k<=N; k++){
            if (visited[k]) cout << k << endl;
        }
        return;
    }

    for (int i=num+1; i<=N; i++) {
        if (!visited[i]) {
            if (isAllFriend(i)) {
                visited[i] = 1;
                dfs(i, cnt+1);
                visited[i] = 0;
            }
        }
    }
}

int main(void) {
    
    cin >> K >> N >> F;
    
    for (int i=0; i<F; i++) {
        int num1, num2;
        cin >> num1 >> num2;

        relation[num1][num2] = true;
        relation[num2][num1] = true;
    }
    for (int j=1; j<=N; j++) {
        if (isEnded) break;

        visited[j] = 1;
        dfs(j, 1);
        visited[j] = 0;
    }

    if (!isEnded) cout << -1 << endl;

}


