#include <iostream>
#include <vector>

using namespace std;

vector<int> numbers;
int N, R;

void perm (int cnt) {
    if (cnt == R) {
        for (int i = 0; i < R; i++) {
            cout << numbers[i] << " ";
        }
        cout << "\n";
        return;
        
    }
    
    for (int i = 1; i <= N; i++) {
        numbers[cnt] = i;
        perm(cnt+1);
    }
    
}

int main(void){
    
    cin >> N >> R;
    numbers = vector<int>(N);

    perm(0);

    return 0;
}