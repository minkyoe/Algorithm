#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<int> num;
vector<int> result;
int N;
int R;
void perm(int cnt) {
    if (cnt == R) {
        for (int i = 0; i < R; i++)
        {
            cout << result[i] << " ";
        }
        cout << "\n";
        return;
    }
    int prevNum = -1;
    for (int i = 0; i < N; i++)
    {
        if (prevNum == num[i]) continue;
        result[cnt] = num[i];
        prevNum = num[i];
        perm(cnt+1);

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
    perm(0); // 아직 고른게 하나도 없음

    return 0;
}