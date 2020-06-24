#include <iostream>

#define MAX 1000000

using namespace std;

int n;
int prime[1000001];
bool isDeleted[1000001]; // 지워짐: true , 안지워짐: false(소수)

int main(void) {
    ios_base :: sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL);

    isDeleted[0] = isDeleted[1] = true;
    isDeleted[2] = false;

    int pn = 0; // prime 배열 인덱스
    for (int i=2; i*i<=MAX; i++) {
        if (isDeleted[i] == false) {
            prime[pn++] = i;
            for (int j=i+i; j<=MAX; j+=i) {
                isDeleted[j] = true;
            }
        }
    }

    while (true) {
        cin >> n;
        if (n == 0) break;

        for (int i=0; i<=pn; i++) {
            if (prime[i] % 2 != 0 && isDeleted[n-prime[i]] == false) { // 첫번째 숫자가 2가 아닌 홀수인 소수, 주어진 숫자에서 첫번째 숫자를 뺀 수가 소수이면
                cout << n << " = " << prime[i] << " + " << n-prime[i] << "\n";
                break;
            }
            else {
                if (i == pn) cout << "Goldbach's conjecture is wrong." << "\n";
            }
        }
        
    }
    return 0;

}