#include <iostream>
#include <algorithm>
#define MAX 1000001

using namespace std;

int main(){
    int dp[MAX] = {};
    dp[0]=dp[1]=0;

    int num;
    cin>>num;

    for(int i=2; i<=num; i++){
        dp[i] = dp[i-1] + 1;
        if(i%2==0) dp[i] = min(dp[i/2]+1,dp[i]);
        if(i%3==0) dp[i] = min(dp[i/3]+1,dp[i]);
    }

    cout<<dp[num];

    return 0;

}