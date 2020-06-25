#include <iostream>

using namespace std;

int E, S, M;

int main(void) {

    cin >> E >> S >> M;

    int e = 1;
    int s = 1;
    int m = 1;

    for (int i=1; ; i++) {
        if (e == E && s == S && m == M) {
            cout << i << endl;
            break;
        }
        e += 1;
        s += 1;
        m += 1;

        if (e == 16) e = 1;
        if (s == 29) s = 1;
        if (m == 20) m = 1;
    }

    return 0;
}