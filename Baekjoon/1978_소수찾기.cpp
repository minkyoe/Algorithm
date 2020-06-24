#include <iostream>

using namespace std;

int n;
int ans; // 소수의 개수

bool isPrime (int num) {
    if (num < 2) return false;
    for (int i=2; i*i<=num; i++) {
        if (num % i == 0) return false;
    }
    return true;
}

int main(void) {
    cin >> n;
    int num;
    for (int i=0; i<n; i++) {
        cin >> num;
        if (isPrime(num)) ans++;
        else continue;
    }
    cout << ans << endl;
}