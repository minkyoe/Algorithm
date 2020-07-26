#include <iostream>
#include <string>
#include <cstring>
using namespace std;

int N; // 단어 개수
string a[101];
int alphaCheck[26];
int ans;

int main(void){
    
    cin >> N;
    ans = 0;

    for (int i=0; i<N; i++) {
        string str = "";
        cin >> str;
        memset(alphaCheck, 0, sizeof(alphaCheck));

        int size = str.length();
        alphaCheck[str[0]-97] = 1;
        int j = 1;
        for (j=1; j<size; j++) {
            if (str[j-1] != str[j]) {
                if (alphaCheck[str[j]-97] == 0) {
                    alphaCheck[str[j]-97]++;
                } else {
                    break;
                }
            }
        }
        if (j == size) {
            ans ++;
        }
    }
    
    cout << ans;

    return 0;
}




