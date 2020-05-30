#include <iostream>
#include <vector>
#define NMAX 201
using namespace std;

int root[NMAX]; // 부모 노드 정보 
int N, M, x, y;

int find(int x) {
    if (x == root[x])
        return x;
    else
        return root[x] = find(root[x]);
}

void uni(int x, int y) {
    x = find(x);
    y = find(y);

    if (x == y) return; // root가 같으면(이미 같은 트리) 합치지 않는다.

    root[x] = y;
}

int main(void) {

    cin >> N;
    cin >> M;

    for (int l=1; l<=N; l++) {
        root[l] = l;
    }

    for (int i=1; i<=N; i++) {
        for (int j=1; j<=N; j++) {
            cin >> x;
            if(x) uni(i, j);
        }
    }

    cin >> x;
    y = find(x);

    for (int k=1; k<M; k++) {
        cin >> x;
        if (y != find(x)) {
            cout << "NO";
            return 0; // 아예 종료
        }
    }

    cout << "YES";
    return 0;
}