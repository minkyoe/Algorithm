#include <iostream>
#include <vector>

using namespace std;

vector<int> numbers;
int N, R;

void comb (int cnt, int cur) {
    if (cnt == R) {
        for (int i = 0; i < R; i++)
        {
            cout << numbers[i] << " ";
        }
        cout << "\n";
        return;
    }
    
    
    for (int i = cur; i <= N; i++)
    {
        numbers[cnt] = i;
        comb(cnt+1, i);
    }
    
    
}

int main(void){
    
    cin >> N >> R;
    numbers = vector<int>(N);

    comb(0, 1);

    return 0;
}