#include <string>
#include <vector>
#include <iostream>
#include <map>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> answers) {
    
    vector<int> answer;
    int max_score = 0;
    int tester1[5] = {1,2,3,4,5};
    int tester2[8] = {2,1,2,3,2,4,2,5};
    int tester3[10] = {3,3,1,1,2,2,4,4,5,5};
    vector<int> count(3, 0);


    for (int i=0; i < answers.size(); i++) {
        if (tester1[i % 5] == answers[i]) count[0]++;
        if (tester2[i % 8] == answers[i]) count[1]++;
        if (tester3[i % 10] == answers[i]) count[2]++;
    }

    max_score = max(count[0], max(count[1], count[2]));

    for (int j = 0; j < 3; j++) {
        if (count[j] == max_score) answer.push_back(j+1);
    }

    return answer;
}