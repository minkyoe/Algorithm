#include <iostream>
#include <vector>

using namespace std;

// 꼭 1이 root여야만 하는건 아니니까, 1의 root를 찾아서 그것에 연결된 노드들 구하기

int N, M;
vector<int> root;

int getRoot(int x) {
    if (x == root[x]) return x;
    else return root[x] = getRoot(root[x]);
}

void merge(int x, int y) {
    x = getRoot(x);
    y = getRoot(y);

    if (x == y) return;

    root[y] = x;
}

int main(void) {

    cin >> N;
    cin >> M;

    root = vector<int> (N+1);
    // 초기화
    for (int i=1; i<=N; i++) {
        root[i] = i;
    }

    // M번 실행
    for (int j=0; j<M; j++) {
        int x, y;
        cin >> x >> y;
        merge(x, y);
    }
    int ans = 0;
    int r = getRoot(1); 
    for (int i = 2; i <= N; i++) {
        if (getRoot(i) == r) ans++;
    } 

    cout << ans << "\n";

    return 0;
}

