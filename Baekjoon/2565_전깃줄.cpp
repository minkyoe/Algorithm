#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<pair<int,int>> vt;
int N; // 전깃줄 개수

int lis[101];
int lower_bound(int start, int end, int target) {
    int mid;
    while (end - start > 0) {
        mid = (start + end) / 2;
        if (lis[mid] < target) start = mid + 1;
        else end = mid;
    }
    return end;
}
int main(void) {
    cin >> N;

    int n1 = 0;
    int n2 = 0;
    for (int i = 0; i < N; i++)
    {
        cin >> n1 >> n2;
        vt.push_back({n1, n2});
    }
    
    sort(vt.begin(), vt.end());
    
    lis[0] = vt[0].second;
    int n = 1;
    int j = 0;

    while (n < N) {
        if (lis[j] < vt[n].second) {
            lis[j+1] = vt[n].second;
            j++;
        }
        else {
            int ans = lower_bound(0, j, vt[n].second);
            lis[ans] = vt[n].second;
        }
        n++;
    }

    cout << N-j-1;

    return 0;
}

