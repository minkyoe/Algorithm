#include <iostream>
#include <vector>

using namespace std;

vector<int> numbers;
vector<int> isSelected;
int N;

void perm (int cnt) {
    if (cnt == N) {
        for (int i = 0; i < N; i++) {
            cout << numbers[i] << " ";
        }
        cout << "\n";
        
        return;
    }
    for (int i = 1; i <= N; i++) {
        if (isSelected[i]) continue;
        numbers[cnt] = i;
        isSelected[i] = 1;
        perm(cnt+1);
        isSelected[i] = 0;
    }
}

int main(void){
    
    cin >> N;
    numbers = vector<int>(N);
    isSelected = vector<int>(N+1);

    perm(0);

    return 0;
}