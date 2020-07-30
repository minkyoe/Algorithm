#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int N;
int R;
vector<int> num;
vector<int> result;

void comb(int cnt, int cur) { // cur: 현재 인덱스
    if (cnt == R)
    {
        for (int i = 0; i < R; i++)
        {
            cout << result[i] << " ";
        }
        cout << "\n";
        return;
    }

    int prevNum = -1;
    for (int i = cur; i < N; i++)
    {
        if (num[i] == prevNum) continue;
        result[cnt] = num[i];
        prevNum = num[i];
        comb(cnt+1, i+1);
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