#include <string>
#include <vector>
#include <iostream>

/***
 * minValue를 그냥 0으로 둬야 test case 9번 통과 ....!
 * **/

using namespace std;
int maxValue = 0;
int minValue = 0;
int maxCeiling = 0;

void setMaxAndMin(int value) {
    if (maxValue < value) maxValue = value;
    if (minValue > value) minValue = value;
    return;
}

void setMaxCeiling(int value) {

    if (maxCeiling == 0) maxCeiling = value;
    else {
        if (maxCeiling < value) maxCeiling = value;
    }
    return;
}


int getSum(int tmp, vector<int> budgets) {
    int sum = 0; // 총액
    
    for (int i=0; i<budgets.size(); i++){
        if (budgets[i] <= tmp) sum += budgets[i];
        else sum += tmp;
    }

    return sum;
}
int solution(vector<int> budgets, int M) {
    int answer = 0;

    // 최대, 최소값 정하기
    for (int i=0; i<budgets.size(); i++) {
        if (i==0) {
            maxValue = budgets[i];
            // minValue = budgets[i]; 
        }
        else setMaxAndMin(budgets[i]);
    }
cout << "min: " << minValue << endl;
cout << "max: " << maxValue << endl;

    int subValue = (minValue + maxValue) / 2;

    while (minValue < subValue) {
        if (getSum(subValue, budgets) > M) maxValue = subValue;
        else if (getSum(subValue, budgets) == M) {
            maxCeiling = subValue;
            break;
        }
        else {
            minValue = subValue;
            setMaxCeiling(subValue);
        }
        if (minValue == subValue) subValue = maxValue;
        else subValue = (minValue + maxValue) / 2;
    }

    answer = maxCeiling;


    return answer;
}

int main(void) {
    int a = solution({ 1,2,3,4,5,6,7,8,9,10 }, 56);
    cout << "answer:: " << a << endl;
}

