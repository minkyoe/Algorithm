#include <iostream>
#include <cstring> 
using namespace std;

int N; // 이동하려는 채널 번호
int M; // 고장난 버튼의 개수
bool broken[10];
int ans = 0;

bool isBroken(int num) {
    if (num == 0) {
        if (broken[0]) return true;
        else return false;
    }
    while (num > 0) {
        if (broken[num%10]) return true;
        num /= 10;
    }
    return false;
}

// num까지 현재 100에서 몇개의 숫자버튼을 눌러야 이동할 수 있는지. num의 길이로 판단할 수 있음
int getDiff(int num) {
    int len = 0;
    if (num == 0) return 1;
    while (num > 0) {
        len++;
        num /= 10;
    }
    return len;
}

int main(void) {
    cin >> N;
    cin >> M;
    memset(broken, false, sizeof(broken));
    for (int i = 0; i < M; i++)
    {
        int tmp = 0;
        cin >> tmp;
        broken[tmp] = true;
    }

    bool flag = false; // 고장나지않은 버튼이 있는지(누를수 있는 버튼이 있는지)
    for (int i = 0; i < 10; i++)
    {
        if (!broken[i]) {
            flag = true;
            break;
        }
    }

    ans = abs(N - 100);
    if (flag) {
        for (int i = 0; i <= 999999; i++)
        {   
            if (isBroken(i)) continue;
            int tmp = getDiff(i) + abs(N-i);
            ans = (ans > tmp) ? tmp : ans;        
        }
    } 

    cout << ans;
    
    return 0;
}