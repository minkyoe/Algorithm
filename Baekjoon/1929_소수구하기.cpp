#include <iostream>

using namespace std;

// 에라토스테네스의 체

int M, N;
bool isDeleted[1000003]; // 지워짐: true , 안지워짐: false(소수)

int main(void) {
    ios_base :: sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL);

    cin >> M >> N;
    
    isDeleted[0] = isDeleted[1] = true;
    isDeleted[2] = false;

    for (int i=2; i<=N; i++) {
        if (isDeleted[i] == false) {
            for (int j=i+i; j<=N; j+=i) {
                isDeleted[j] = true;
            }
        }
    }

    for (int k=M; k<=N; k++) {
        if (isDeleted[k] == false) {
            cout << k << "\n";
        }
    }

}