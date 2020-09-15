#include <iostream>

using namespace std;

int main (void) {

    int N, W, H, L;

    cin >> N >> W >> H >> L;

    int n = W / L;
    int m = H / L;
    int cnt = n*m;

    if (cnt > N) cout << N;
    else cout << cnt;

    return 0;
}
