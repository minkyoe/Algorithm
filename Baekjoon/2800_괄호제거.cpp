#include <iostream>
#include <stack>
#include <vector>
#include <string>
#include <cstring>
#include <set>

using namespace std;
stack<int> st;               // 괄호 짝 인덱스 저장을 위한 스택
vector<pair<int, int>> gwal; // 괄호 짝 저장
set<string> ans;
bool selected[10];     // gwal 안에 괄호 선택되었는지 (true면 삭제될 괄호짝)
bool strSelected[200]; // 문자열 선택되었는지 (true면 괄호 삭제)
string s = "";

void func(int idx, int cnt)
{
    if (cnt != 0)
    { // 하나 이상은 true여야함 . 하나도 제거 안된거는 ans에 담으면 안되기 때문!
        string newS = "";
        for (int i = 0; i < s.length(); i++)
        {
            if (strSelected[i] == true)
                continue;
            newS += s[i];
        }
        ans.insert(newS);
    }

    for (int i = idx; i < gwal.size(); i++)
    {
        if (selected[i])
            continue;
        selected[i] = true;
        strSelected[gwal[i].first] = true;
        strSelected[gwal[i].second] = true;

        func(idx + 1, cnt + 1);
        selected[i] = false;
        strSelected[gwal[i].first] = false;
        strSelected[gwal[i].second] = false;
    }
}

int main(void)
{
    cin >> s;
    memset(selected, false, sizeof(selected));
    for (int i = 0; i < s.length(); i++)
    {
        char c = s[i];
        if (c == '(')
            st.push(i);
        else if (c == ')')
        {
            int tmp = st.top();
            st.pop();
            gwal.push_back({tmp, i});
        }
    }

    func(0, 0);

    for (set<string>::iterator it = ans.begin(); it != ans.end(); it++)
    {
        cout << *it << endl;
    }

    return 0;
}