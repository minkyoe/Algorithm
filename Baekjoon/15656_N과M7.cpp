#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> numbers;
vector<int> result;
int N, R;

void perm (int cnt) {
    if (cnt == R) {
        for (int i = 0; i < R; i++)
        {
            cout << result[i] << " ";
        }
        cout << "\n";
        return;
    }

    for (int i = 0; i < N; i++)
    {   
        result[cnt] = numbers[i];
        perm(cnt+1);
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

    perm(0);

    return 0;
}