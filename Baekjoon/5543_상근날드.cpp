#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<int> burger(3);
vector<int> drink(2);
int ans = 3950; // 2000+2000-50

int main(void) {

    for (int i=0; i<3; i++){
        cin >> burger[i];
    }
    for (int i=0; i<2; i++){
        cin >> drink[i];
    }

    for (int i=0; i<burger.size(); i++) {
        for (int j=0; j<drink.size(); j++) {
            int sum = burger[i] + drink[j] - 50;
            ans = ans > sum ? sum : ans;
        }
    }

    cout << ans;
  
    return 0;
}