#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int tc;
int n; // 전화번호 수
vector<string> list;
bool isConsistent; // 일관성 있는지

int main(void)
{
    cin >> tc;

    for (int i = 0; i < tc; i++)
    { // TEST CASE

        /** 초기화 */
        list.clear();
        isConsistent = true;
        cin >> n;

        for (int j = 0; j < n; j++)
        {
            string str = "";
            cin >> str;
            list.push_back(str);
        }

        sort(list.begin(), list.end());

        for (int i = 0; i < list.size() - 1; i++)
        {
            string standard = list[i];
            int len = standard.length();

            if (list[i + 1].length() < len) continue;
            string compare = list[i + 1].substr(0, len);
            if (standard == compare)
            {
                isConsistent = false;
                break;
            }
        }

        if (!isConsistent)
        {
            cout << "NO" << "\n";
        }
        else
        {
            cout << "YES"<< "\n";
        }
    }

    return 0;
}