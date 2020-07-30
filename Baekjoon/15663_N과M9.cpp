#include <iostream>
#include <vector>
#include <algorithm>
#include <math.h>

using namespace std;

int N, R;
vector<int> num;
vector<int> result;
vector<int> isSelected;

void perm(int cnt)
{
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
    for (int i = 0; i < N; i++)
    {
        if (num[i] == prevNum || isSelected[i])
            continue;
        result[cnt] = num[i];
        isSelected[i] = 1;
        prevNum = num[i];
        perm(cnt + 1);
        isSelected[i] = 0;
    }
}

int main(void)
{

    cin >> N >> R;
    num = vector<int>(N);
    isSelected = vector<int>(N);
    result = vector<int>(R);

    for (int i = 0; i < N; i++)
    {
        cin >> num[i];
    }

    sort(num.begin(), num.end(), less<int>());
    perm(0);

    return 0;
}