#include <iostream>
#include <vector>
#include <string>
#include <math.h>
#include <algorithm>
using namespace std;

int alphabet[26] = {0,};
int ans = 0;
int nCnt = 9;
vector<int> vec = {0,};

int main(void) {
    int num;

    cin >> num;

    for (int i=0; i<num; i++) {
        string str; 
        cin >> str;

        for (int j=0; j<str.size(); j++) {
            alphabet[str[j]-65] += pow(10, str.size()-j-1);
        }
    }

    for (int l=0; l<26; l++) {
        if(alphabet[l]) {
            vec.push_back(alphabet[l]); // 정렬하기 위해 vector의 push
        }
    }

    sort(vec.begin(), vec.end(), greater<int>()); // 10000 10 1 

    for (int k=0; k<vec.size(); k++) {
        ans += vec[k]*(nCnt--);
    }

    cout << ans << endl;


}