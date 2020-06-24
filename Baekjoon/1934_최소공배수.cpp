#include <iostream>

using namespace std;

int GCD (int a, int b) {
    while (b != 0) {
        int r = a % b;
        a = b;
        b = r;
    }
    return a;
}

int main(void) {
    int a,b;
    int n;
    cin >> n;

    for (int i=0; i<n; i++) {
        cin >> a >> b;
        cout << (a*b)/GCD(a,b) << endl;
    }
}