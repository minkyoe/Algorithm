#include <iostream>
#include <vector>
#define ALPHA_MAX 26 // 알파벳 배열 크기 a-z

using namespace std;

int N, K;
int alphaVisited[ALPHA_MAX] = {0,};
vector<string> voca;
int ans = 0;

int CountCanRead() {
    int canReadVoca = 0;
    for (int i=0; i<N; i++) { // 단어개수
        int canReadAlpha = 0;
        int vocaSize = voca[i].size();

        for (char c : voca[i]) {
            if (alphaVisited[c-97]) canReadAlpha++;
        }
        if (vocaSize == canReadAlpha) canReadVoca++;
    }
    return canReadVoca;
}

void DFS(int start, int cnt) {
    if (cnt == K) {
        int cnt = CountCanRead();
        ans = ans < cnt ? cnt : ans; 
        return;
    }

    for (int i=start; i<ALPHA_MAX; i++) {
        if (!alphaVisited[i]) {
            alphaVisited[i] = true;
            DFS(i, cnt+1);
            alphaVisited[i] = false;
        }
    }
}

int main(void) {
    cin.tie(NULL);
    std::ios::sync_with_stdio(false);

    cin >> N >> K;

    K = K-5; // a,n,t,i,c 빼고 배운 글자 수

    alphaVisited['a'-97] = 1;
    alphaVisited['n'-97] = 1;
    alphaVisited['t'-97] = 1;
    alphaVisited['i'-97] = 1;
    alphaVisited['c'-97] = 1;

    voca = vector<string> (N);

    for (int i=0; i<N; i++) {
        cin >> voca[i];
    }

    DFS(0, 0);
    cout << ans << endl;
  
    return 0;
}
