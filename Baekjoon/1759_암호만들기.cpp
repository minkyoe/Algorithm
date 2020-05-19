#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

// 암호는 서로 다른 L개의 알파벳 소문자들로 구성되며 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성

int L; // 암호 글자 수
int C; // 주어진 알파벳 수
vector<string> key; // 암호
vector<string> alphabet;
vector<int> visited;

vector<char> moeum = {'a', 'e', 'i', 'o', 'u'};

// 모음 최소 한개, 자음 최소 두개인지 체크
bool isRightKey(string str) {
    int cnt = 0; // 모음 카운트
    for(char c : str) {
        for (char m : moeum) {
            if (c == m) {
                cnt++;
                break;
            }
        }
    }

    if (1<= cnt && L-cnt >=2) return true;
    else return false;
}

void dfs(int idx, int count) {

    if (count == L) {
        string str = "";

        for (int i=0; i<C; i++) {
            if (visited[i]) {
                str += alphabet[i];
            }
        }
        if (isRightKey(str)) cout << str << endl;
        return;
    }

    for (int k=idx+1; k<C; k++) {
        if (!visited[k]) {
            visited[k] = 1;
            dfs(k, count+1);
            visited[k] = 0;
        }
    }

    return;
    
}

int main(void) {

    cin >> L >> C;

    key = vector<string> (L, " ");
    alphabet = vector<string> (C, " ");
    visited = vector<int> (C, 0);

    for (int i=0; i<C; i++) {
        cin >> alphabet[i];
    }

    sort(alphabet.begin(), alphabet.end()); // abc순으로 정렬

    for (int j=0; j<alphabet.size(); j++) {
        if (C-j < L) break; // 암호 글자수 못채우므로 break
        visited[j] = 1;
        dfs(j, 1);
        visited = vector<int> (C, 0); // 초기화
    }

}