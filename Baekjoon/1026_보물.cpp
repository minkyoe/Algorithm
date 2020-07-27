#include <iostream>
#include <algorithm>

using namespace std;
int a[50];
int b[50];
int main(void){
    
    int N;
    int ans = 0;
    cin >> N;

    for (int i = 0; i<N; i++) {
        cin >> a[i];
    }

    for (int i = 0; i<N; i++) {
        cin >> b[i];
    }

    sort(a, a+N);
    sort(b, b+N, greater<int>());

    for (int i = 0; i<N; i++) {
        ans += a[i]*b[i];
    }

    cout << ans;


    return 0;
}