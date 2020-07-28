#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, R;
vector<int> num;
vector<int> result;

void comb(int cnt, int cur) {
    if (cnt == R) {
        for (int i = 0; i < R; i++)
        {
            cout << result[i] << " ";
        }
        cout << "\n";
        return;
    }

    for (int i = cur; i < N; i++)
    {
        result[cnt] = num[i];
        comb(cnt+1, i);
    }
}

int main(void) {

    cin >> N >> R;
    num = vector<int>(N);
    result = vector<int>(R);

    for (int i = 0; i < N; i++)
    {
        cin >> num[i];
    }

    sort(num.begin(), num.end(), less<int>());

    comb(0, 0);    

    return 0;
}