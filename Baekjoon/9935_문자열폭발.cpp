#include <iostream>
#include <string>

using namespace std;

// string -> pop_back() !!
// 문자열의 최대길이는 백만, 시간제한 1초 -> 시간복잡도 O(N) 정도로 해결해야함

string origin = "";
string bomb = "";
string ans;
int bombSize;
bool fireFlag = true;

int main(void) {

    cin >> origin;
    cin >> bomb;
    bombSize = bomb.size();

    for (int i=0; i<origin.size(); i++) {
        ans += origin[i];

        if (origin[i] == bomb[bombSize-1] && ans.size() >= bombSize) {
            for (int j=0; j<bombSize; j++) {
                fireFlag = true;
                if (ans[ans.size()-j-1] != bomb[bombSize-j-1]) {
                    fireFlag = false;
                    break;
                } 
            }

            if (fireFlag) {
                for (int k=bombSize; k>0; k--) {
                    ans.pop_back();
                }
            }
            else continue;
        }
    }

    if (ans.empty()) cout << "FRULA" << "\n";
    else cout << ans << "\n";

    return 0;
}

