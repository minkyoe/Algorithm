#include <iostream>
#include <string>
#include <cmath>

using namespace std;

string N;
int ans;

int main(void) {

    cin >> N;
    int strLen = N.size();

    for (int i=1; i<strLen; i++) {
        ans += i*9*pow(10, i-1);
    }

    ans += strLen*(stoi(N)-pow(10, strLen-1)+1);
    cout << ans;
  
    return 0;
}