#include <string>
#include <vector>
#include <iostream>
#define MAX 1000
using namespace std;


int solution(string s) {
    int answer = s.size();
    string str = s;
    string shortenStr = "";
    int strLen = str.size(); // 문자열 길이
    if (strLen == 1)  {
        answer = 1;
        return answer;
    }
    for (int i=1; i<=strLen/2; i++) { // 비교 개수!!!!!!!!!!!!!!!
        string tmp = str.substr(0, i);
        int sameCnt = 1;
        for (int j=i; j<=strLen; j+=i) { // 문자열 끝까지 비교
            string target = str.substr(j, i); // 비교 할 문자열 
    
            if (target == tmp) {
                sameCnt += 1;
                
            } else { // 다음 문자열이 같지 않다면
                
                if (sameCnt == 1) shortenStr += tmp;
                else {
                    string t = to_string(sameCnt) + tmp; // 'aa' -> '2a'
                    shortenStr += t;
                }
                tmp = target;
                sameCnt = 1;
            }
            if (j + i > strLen) { // 여기서 비교안해주면 마지막 문자열 못붙임!!
                shortenStr += tmp;
            }
        }

        // if (i==1) answer = shortenStr.size();
        // else {
        //     if (answer > shortenStr.size()) answer = shortenStr.size();
        // }

        answer = (answer > shortenStr.size())? shortenStr.size() : answer;

        shortenStr = "";
    }



    cout << "answer:: " << answer << endl;
    

    return answer;
}

int main(void) {
    string str = "";
    cin >> str;

    solution(str);

}