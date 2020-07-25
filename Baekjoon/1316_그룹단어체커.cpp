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
   
    ans = N;

    for (int i=0; i<N; i++) {
        string str = "";
        cin >> str;
        memset(alphaCheck, 0, sizeof(alphaCheck));

        int size = str.length();
        for (int j=1; j<size; j++) {
            string s1 = str.substr(j-1,1);
            string s2 = str.substr(j,1);

            int alphaIdx = stoi(s2.c_str());
            cout << alphaIdx << endl;
            if (s1 != s2) {
                if (alphaCheck[alphaIdx]) {
                    ans --;
                    break;
                }
                alphaCheck[alphaIdx] = 1;
            }
           
        }
    }

    
    // memset(a, 0, sizeof(a));
    // ans = N;

    // for (int i=0; i<N; i++) {
    //     cin >> a[i];
    // }

    // for (int aIdx=0; aIdx<N; aIdx++) {
    //     string str = "";
    //     cin >> str;
    //     int isNotFlag = false;
    //     cout << "str: " << str << endl;

    //     for (int i=0; i<str.length(); i++) { 
    //         string s = str.substr(i,1);

    //         for (int j=0; j<str.length(); j++) {
    //             if (j == i) continue;
    //             string s2 = str.substr(j,1);
    //             int tmp = (j > idx) ? j-idx : idx-j;
                
    //             if (s == s2 && tmp > 1) {
    //                 cout << s <<" " << s2 << endl;
    //                 cout << "tmp: " << tmp << endl;
    //                 isNotFlag = true;
    //             }
    //         }
    //         if (isNotFlag) {
    //             ans--;
    //             break;
    //         }
    //     }
    // }
    

    cout << ans;

    return 0;
}




