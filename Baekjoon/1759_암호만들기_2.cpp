#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

int L; // 암호 문자 개수
int C; // 주어진 알파벳 개수
vector<char> key;
bool selected[15];

bool isRightSecret(string str)
{
    int mCnt = 0;
    int jCnt = 0;
    for (char c : str)
    {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
        {
            mCnt++;
        }
        else
        {
            jCnt++;
        }
    }

    if (jCnt >= 2 && mCnt >= 1)
        return true;
    else
        return false;
}

void dfs(int idx, int cnt)
{
    if (cnt == L)
    {
        string s = "";
        for (int i = 0; i < C; i++)
        {
            if (selected[i])
            {
                s += key[i];
            }
        }
        if (isRightSecret(s))
        {
            cout << s << endl;
        }
    }

    for (int i = idx; i < C; i++)
    {
        selected[i] = true;
        dfs(i + 1, cnt + 1);
        selected[i] = false;
    }
}

int main(void)
{

    //     4 6
    // a t c i s w

    cin >> L >> C;
    char tmp = 0;
    for (int i = 0; i < C; i++)
    {
        cin >> tmp;
        key.push_back(tmp);
    }
    sort(key.begin(), key.end());
    dfs(0, 0);

    return 0;
}