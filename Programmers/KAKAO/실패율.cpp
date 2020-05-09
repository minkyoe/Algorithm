#include <string>
#include <vector>
#include <iostream>
#include <algorithm>


using namespace std;
vector<pair<float, int>> failRatestageNum;

bool cmp(pair<float, int> a, pair<float, int> b) {
    if (a.first == b.first) {
        return a.second < b.second;
    }

    return a.first > b.first;
}

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;

    for (int i=1; i<=N; i++) {
        float bunja = 0;
        float bunmo = 0;
        float failRate = 0; 

        for (int a=0; a<stages.size(); a++) {
            if (stages[a] >= i) {
                if (stages[a] == i) {
                    bunja ++; 
                    bunmo ++;
                } else {
                    bunmo ++;
                }
            } 
        }

        if (bunja != 0 && bunmo != 0) failRate = bunja/bunmo;
       
        failRatestageNum.push_back(make_pair(failRate, i));
    }
    sort(failRatestageNum.begin(), failRatestageNum.end(), cmp);
    for (auto it : failRatestageNum) {
        answer.push_back(it.second);
    }
  
    return answer;
}

int main(void) {
   vector<int> answer = solution(5, {2, 1, 2, 6, 2, 4, 3, 3}); // -> [3,4,2,1,5]
}