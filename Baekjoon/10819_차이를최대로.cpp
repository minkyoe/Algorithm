#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N;
vector<int> num;
int ans = 0;

int cal(vector<int> &v) {
    int sum = 0;
    for (int i = 1; i < v.size(); i++)
    {
        sum += abs(num[i] - num[i-1]);
    }

    return sum;    
}

int main(void) {
    cin >> N;

    int tmp = 0;
    for (int i = 0; i < N; i++)
    {
        cin >> tmp;
        num.push_back(tmp);
    }

    sort(num.begin(), num.end());

    do {
        int result = cal(num);
        ans = max(ans, result);
    } while (next_permutation(num.begin(), num.end()));

    cout << ans;
    
    return 0;
}