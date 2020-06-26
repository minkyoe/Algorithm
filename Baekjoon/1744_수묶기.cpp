#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> nums;

int main(void) {

    ios_base :: sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL);

    int size;

    cin >> size;
    nums = vector<int> (size);

    for (int i=0; i<size; i++) {
        cin >> nums[i];
    }

    sort(nums.begin(), nums.end(), less<int>());

    // 첫 시도 -> 반례 와장창..
    // int sum = 0;
    // for (int j=size-1; j>=1; j-=2) {
    //     if (nums[j] > 0 && nums[j-1] > 0) {
    //         sum += nums[j] * nums[j-1];
    //     }
    //     else {
    //         sum += nums[j];
    //         sum += nums[j-1];
    //     }
    // }

    // cout << sum << "\n";


    int sum = 0;
    int start = 0;
    int end = size - 1;

    // 작은 수 부터 정렬해놨으니
    // 왼쪽부터 음수 찾아서 곱곱 (ex. -6 -5 -1)
    for (; start < size-1; start += 2) {
        if (nums[start] < 1 && nums[start + 1] < 1) {
            sum += nums[start] * nums[start + 1];
        } else break;
    }

    // 양수
    for (; end > 0; end -= 2) {
        if (nums[end] > 1 && nums[end - 1] > 1) {
            sum += nums[end] * nums[end - 1];
        } else break;
    }
    
    // 남은 수 다 더하기
    for (; end >= start; end--) {
        sum += nums[end];
    }

    cout << sum << "\n";

    return 0;
}