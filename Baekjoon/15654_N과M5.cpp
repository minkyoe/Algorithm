#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> numbers;
vector<int> result;
vector<int> isSelected; // numbers index 에 따른 사용 여부 ex.isSelected[0] = true --> numbers[0]에 해당하는 숫자가 이미 사용되었다는 뜻
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
        if (isSelected[i]) continue;
        result[cnt] = numbers[i];
        isSelected[i] = true;
        perm(cnt+1);
        isSelected[i] = false;
    }
    
    
}

int main(void){
    
    cin >> N >> R;
    numbers = vector<int>(N);
    isSelected = vector<int>(N);
    result = vector<int>(R);
    for (int i = 0; i < N; i++)
    {
        cin >> numbers[i];
    }
    sort(numbers.begin(), numbers.end(), less<int>());

    perm(0);

    return 0;
}