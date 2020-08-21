#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

pair<int, int> calculation(vector<int> &num, int index, int cur, int plus, int minus, int mul, int div) {

    int size = num.size();

    if (index == size) {
        return make_pair(cur, cur);
    }

    vector<pair<int,int>> res;
    if (plus > 0) {
        res.push_back(calculation(num, index+1, cur+num[index], plus-1, minus, mul, div));
    }

    if (minus > 0) {
        res.push_back(calculation(num, index+1, cur-num[index], plus, minus-1, mul, div));
    }

    if (mul > 0) {
        res.push_back(calculation(num, index+1, cur*num[index], plus, minus, mul-1, div));
    }

    if (div > 0) {
        res.push_back(calculation(num, index+1, cur/num[index], plus, minus, mul, div-1));
    }

    auto ans = res[0];
    for(auto p : res) {
        if (ans.first < p.first) {
            ans.first = p.first;
        }
        if (ans.second > p.second) {
            ans.second = p.second;
        }
    }
    return ans;
}

int main(void)
{
   int n;
   cin >> n;
   vector<int> num(n);
   for (int i = 0; i < n; i++)
   {
       cin >> num[i];
   }

   int plus, minus, mul, div;
   cin >> plus >> minus >> mul >> div;
   auto pair = calculation(num, 1, num[0], plus, minus, mul, div);
   cout << pair.first << '\n';
   cout << pair.second << '\n';

    return 0;
}