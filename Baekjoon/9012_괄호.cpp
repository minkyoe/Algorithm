#include <iostream>
#include <stack>
using namespace std;

int main(void) {
    int tc = 0;
    cin >> tc;

    for (int i = 0; i < tc; i++)
    {
        string s = "";
        cin >> s;
        stack<char> st;
        string ans = "YES"; // YES이면 유효한 문자열

        for(char c : s) {
            if (c == '(') {
                st.push(c);
            } 
            else {
                if (!st.empty()) {
                    char top = st.top();
                    if (top == '(') {
                        ans = "YES";
                        st.pop();
                    } else {
                        ans = "NO";
                        break;
                    }
                } else {
                    ans = "NO";
                    break;
                }
            }
        } // end of for
        if (!st.empty()) ans = "NO";

        cout << ans << "\n";
    }
    

    return 0;
}