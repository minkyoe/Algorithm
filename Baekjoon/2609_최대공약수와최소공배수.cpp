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

    cin >> a >> b;
    cout << GCD(a,b) << endl;
    cout << (a*b)/GCD(a,b) << endl;
}