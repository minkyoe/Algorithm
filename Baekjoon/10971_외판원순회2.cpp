#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N; // 도시 개수
vector<int> city;
int W[11][11]; // 비용
int ans = 21000000;
int main(void) {

    cin >> N;
    for (int i = 0; i < N; i++)
    {
        city.push_back(i);
    }

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> W[i][j];
        }
        
    }
   
    do {
        int flag = true;
        int sum = 0;
        for (int i = 0; i < N-1; i++)
        {            
            if (W[city[i]][city[i+1]] == 0) {
                flag = false;
                break;
            } else {
                sum += W[city[i]][city[i+1]];
            }

           
        } // end of for
        if (flag && W[city[N-1]][city[0]] != 0) {
            sum += W[city[N-1]][city[0]]; // 원래위치까지 오는데 비용
            ans = min(sum, ans);
        } 
    } while (next_permutation(city.begin()+1, city.end()));

    cout << ans;

    
    return 0;
}