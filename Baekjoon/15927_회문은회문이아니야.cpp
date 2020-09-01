#include <iostream>
#include <string>

using namespace std;

string str;

bool isPalin(string s) {
    for (int i = 0; i < s.length()/2; i++)
    {
        if (s[i] != s[s.length()-i-1]) {
            return false;
        }
    }
    return true;
}

int main(void) {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> str;

    // 다 같은 문자인지 비교
    for(int i = 0; i < str.length(); i++){
        if (str[0] != str[i]) break;
        else {
            if (i == str.length()-1) { // 다 같은 문자이면 -1 출력
                cout << "-1";
                return 0;
            }
        }
    }
   
    if(isPalin(str)) cout << str.length()-1;
    else cout << str.length();

    return 0;
}