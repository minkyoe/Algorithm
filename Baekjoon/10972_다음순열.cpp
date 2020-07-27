#include <iostream>
#include <algorithm> // swap
#include <vector>

using namespace std;

vector<int> num;

int main(void){
    
    int N;
    int ans = 0;
    cin >> N;
    num = vector<int>(N);

    for (int i = 0; i<N; i++) {
        cin >> num[i];
    }

    int j = 0;
    for(int i=N-1; i>=0; i--) {
        if (num[i] <= num[i-1]) continue;
        else {
            if (i==0) {
                cout << "-1";
                return 0;
            }
            else {
                j = i-1;
                break;
            }
        }
    }

    int k = 0;
    for(int i=N-1; i>j; i--) {
        if (num[j] >= num[i]) continue;
        else {
            k = i;
            break;
        }
    }

    swap(num[j], num[k]);

    int a = j+1;
    int b = N-1;
    while (a < b) {
        swap(num[a], num[b]);
        a += 1;
        b -= 1;
    }

    for (int n=0; n<N; n++) {
        cout << num[n] << " ";
    }

    return 0;
}