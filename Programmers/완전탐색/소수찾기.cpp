#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

/*
* string sort하여 가장 큰 수 만들어줌
* 에로타스테네스의 체로 소수 판별 
* 주어진 numbers에 해당하는 소수인지 판별 (substr로 해당 자리 number확인했으면 자르기)
* 소수 && 해당 소수 ==> answer ++
*/

bool isRightPrime (int num, string numbers);
int solution(string numbers) {
    int answer = 0; // 소수의 개수
    sort(numbers.begin(), numbers.end(), greater<int>());

    int n = stoi(numbers);
    vector<int> numbersArray(n+2);
    
    for (int i=2; i<=n; i++) {
        if (numbersArray[i] == 1) continue;
        for (int j=i+i; j<=n; j+=i) {
            numbersArray[j] = 1;
        }
    }

    for (int i=2; i<=n; i++) {
        if (numbersArray[i] == 0 && isRightPrime(i,numbers)) answer++;
    }
    
    return answer;
}
bool isRightPrime (int num, string numbers) {
    string stNum = to_string(num);

    for (int i=0; i<stNum.size(); i++) {
        int idx = numbers.find(stNum.substr(i,1));
        if (idx >= 0) numbers = numbers.substr(0,idx) + numbers.substr(idx+1);
        else return false;
    }
    return true;
}
