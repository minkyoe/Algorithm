#include <iostream>
using namespace std;

int main(){
    int num,count=0;
    cin>>count;

    int dp[12]={0};
    dp[1]=1;
    dp[2]=2;
    dp[3]=4;

    while(count--){
        cin>>num;
        for(int i=4;i<=num;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }    
        cout<<dp[num]<<endl;

    }
    


    return 0;

}