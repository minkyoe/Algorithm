#include <iostream>
#include <string>
#include <stack>
using namespace std;

string origin;
string answer = "";
stack<char> st;

int main(void)
{

    cin >> origin;

    for (auto k : origin) {
		if (k >= 'A' && k<='Z') {
			answer += k;
		}
		else if (k == '(') {
			st.push(k);
		}
		else if (k == ')') {
			while (!st.empty() && st.top() != '(') {
				answer += st.top();
				st.pop();
			}
			st.pop();
		}
		else if (k == '*' || k == '/') {
			while (!st.empty() && (st.top() == '*' || st.top() == '/')) {
				answer += st.top();
				st.pop();
			}

			st.push(k);
		}
		else {
			while (!st.empty() && st.top() != '(') {
				answer += st.top();
				st.pop();
			}
			st.push(k);
		}
	}

    // 스택에 남은것들 pop
	while (!st.empty()) {
		answer += st.top();
		st.pop();
	}
	
	cout << answer << endl;
  
}