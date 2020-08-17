#include <iostream>
#include <vector>
#include <cstring>
#define NMAX 15
using namespace std;

int N;
int t[NMAX+1];
int pay[NMAX+1];
int ans = 0;
void go (int day, int sum) {
    if (day == N+1) {
        ans = ans < sum ? sum : ans;
        return;
    }
    if (day > N+1) {
        return;
    }
    go(day+1, sum);
    go(day+t[day], sum+pay[day]);
}
int main(void)
{
    cin >> N;
    for (int i = 1; i <= N; i++)
    {
        cin >> t[i] >> pay[i];
    }

    go(1, 0); // day, sum
    cout << ans;
    
    return 0;
}