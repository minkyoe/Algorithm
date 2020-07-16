#include<iostream>
#include<string>
#include<vector>
#include<set>
#include<cstring>
 

using namespace std;

int tc;
bool selected[7];
int len;
int answer;
string input;

vector<char> v;
set<int> visited;
bool Calculate(int Data)    // 소수인지 판단하는 함수
{
    if (Data < 2) return false;
    for (int i = 2; i * i <= Data; i++)
    {
        if (Data % i == 0) return false;
    }
    return true;
}
 
int SumOf_Vector()
{
    int Sum = 0;
    for (int i = 0; i < v.size(); i++)
    {
        Sum = Sum + (v[i] - '0');
        if (i != v.size() - 1) Sum = Sum * 10;
    }
    return Sum;
}
 
void DFS(int cnt)
{
    if (cnt > len) return;
 
    if (v.size() != 0)
    {
        int Value = SumOf_Vector();
        if (visited.find(Value) == visited.end())
        {
            visited.insert(Value);
            if (Calculate(Value) == true) answer++;
        }
    }
 
    for (int i = 0; i < len; i++)
    {
        if (selected[i] == true) continue;
        selected[i] = true;
        v.push_back(input[i]);
        DFS(cnt + 1);
        selected[i] = false;
        v.pop_back();
    }
}

int main(void) {

    cin >> tc;
    while (tc--) {
        input = "";
        visited.clear();
        memset(selected, false, sizeof(selected));
        answer = 0;
        len = 0;
        v.clear();

        cin >> input;
        len = input.size();
        DFS(0);
        cout << answer << endl;
    }

    return 0;
}