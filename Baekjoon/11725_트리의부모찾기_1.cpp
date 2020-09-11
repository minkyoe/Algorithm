#include <iostream>
#define MAX 100000
#define ROOT 1
using namespace std;

// 시간초과........유니온 파인드 ........ 이렇게 풀면 안된다 .......

int parents[MAX+1];
int N; // 노드 개수

void make() {
    for (int i = 1; i <= N; i++)
    {
        parents[i] = i;
    }
}
int find(int a){
    if(parents[a] == a) {
        return a;
    }
    return find(parents[a]);
}
void merge(int a, int b) {
    if(find(a) == 1) {
        parents[b] = a;
        return;
    }
    if(find(b) == 1) {
        parents[a] = b;
        return;
    }
}
int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;

    make();

    int a;
    int b;

    for (int i = 1; i < N; i++)
    {
        cin >> a >> b;
        merge(a,b);
    }

    for (int i = 2; i <= N; i++)
    {
        cout << parents[i] << "\n";
    }

    return 0;
}