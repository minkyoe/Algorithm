#include <iostream>
#include <algorithm>

using namespace std;

int nanjaeng[9];
int sum = 0;

int main(void) {
   
    for (int i=0; i<9; i++) {
        cin >> nanjaeng[i];
        sum += nanjaeng[i];
    }

    sort (nanjaeng, nanjaeng+9);

    for (int i=0; i<9; i++) {
        for (int j=i+1; j<9; j++) {
            if (i == j) continue;
            if (sum - nanjaeng[i] - nanjaeng[j] == 100) { 
                for (int k=0; k<9; k++) {
                    if (k == i || k == j) continue;
                    cout << nanjaeng[k] << endl;
                }
                return 0;
            }
        }
    }

    return 0;
}