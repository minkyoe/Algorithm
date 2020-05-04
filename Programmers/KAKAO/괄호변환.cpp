#include <string>
#include <vector>
#include <stack>
#include <iostream>

using namespace std;

/**
 * 
 * stack 이용해서 괄호 짝 맞는지 체크함
 * 재귀함수
 * 
 * **/

// 올바른 문자열인지 판단
bool isRight(string p) {
    stack<char> stack;

    for (char c : p) {
        if (c == '(') {
            stack.push(c);
        } else {
            if (!stack.empty()) stack.pop();
            else stack.push(c);
        }
    }

    if (stack.empty()) return true;
    else return false;
}

string seperate(string p) {
    if (isRight(p)) return p; // 이미 올바른 문자열이면 리턴

    int lCount = 0; // "("
    int rCount = 0; // ")"
    string u = "";
    string v = "";


    for (int i=0; i<p.size(); i++) {
        string c = p.substr(i, 1);
        if (c == "(")  lCount ++;
        else rCount ++;

        if (lCount == rCount) {
            u = p.substr(0, lCount+rCount); // 첫번째 문자부터 체크한 문자까지
            v = p.substr(lCount+rCount, p.size()-1); // 그 뒤 문자열
            break;
        }
    }

    if (isRight(u)) { // u가 올바른문자열일 때
        string tmp = seperate(v);
        return u+tmp;
    }
    else { // u가 올바르지않은문자열 일 때
        string tmp = "(" + seperate(v) + ")";
        if (u.size() <= 2) u = ""; // u의 길이가 2이하일때 고려
        else {
            u = u.substr(1, u.size()-2); // u의 첫번째와 마지막 문자 자름
            string result = "";
            for (int i=0; i<u.size(); i++) { // u의 괄호 방향 바꾸기
                string tmp = u.substr(i, 1);
                if (tmp == "(") result += ")";
                else result += "(";
            }
            u = result;
        }

        return tmp+u;
    }    
} 

string solution(string p) {
    string answer = "";

    if (p == "") return p; // 빈문자열이면 그냥 리턴.
    else answer = seperate(p);
 
    return answer;
}
