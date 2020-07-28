#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> numbers;
vector<int> result;
int N, R;

void comb (int cnt, int cur) {
    if (cnt == R) {
        for (int i = 0; i < R; i++)
        {
            cout << result[i] << " ";
        }
        cout << "\n";
        return;
    }

    for (int i = cur; i < N; i++)
    {   
        result[cnt] = numbers[i];
        comb(cnt+1, i+1);
    }
    
    
}

int main(void){
    
    cin >> N >> R;
    numbers = vector<int>(N);
    result = vector<int>(R);
    for (int i = 0; i < N; i++)
    {
        cin >> numbers[i];
    }
    sort(numbers.begin(), numbers.end(), less<int>());

    comb(0, 0);

    return 0;
}