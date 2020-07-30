#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<int> num;
vector<int> result;
int N;
int R;
void comb(int cnt, int cur) {
    if (cnt == R) {
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
        if (prevNum == num[i]) continue;
        result[cnt] = num[i];
        prevNum = num[i];
        comb(cnt+1, i);
    }
    
}
int main(void) {

    cin >> N >> R;
    num = vector<int>(N);
    result = vector<int>(R);
    for (int i = 0; i < N; i++)
    {
        cin >>  num[i];
    }

    sort(num.begin(), num.end(), less<int>());
    comb(0, 0); // 아직 고른게 하나도 없음, 시작 인덱스

    return 0;
}