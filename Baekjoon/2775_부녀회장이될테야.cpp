#include <iostream>

using namespace std;

int k, n; // k층 n호

int recur(int k, int n) {
    if (k == 0) {
        return n;
    }
    
    int sum = 0;
    for (int i = 1; i <= n; i++)
    {
        sum += recur(k-1, i);
    }
    
    return sum;
}

int main(void) {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int tc;
    cin >> tc;

    for (int testCase = 0; testCase < tc; testCase++)
    {
        cin >> k;
        cin >> n;

        cout << recur(k, n) << "\n";
    }

    return 0;
}