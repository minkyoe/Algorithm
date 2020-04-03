#include <iostream>
#include <cmath>
#include <cstdlib>

using namespace std;
int f[41] = {0,};

int fib(int n){
    if(n==1){
        f[1] = 1;
        return 1;
    }else if(n<=0){
        f[0] = 0;
        return 0;
    }
    
    if(f[n]!=0){ // 이미 계산이 된 경우. (처음에 배열을 0으로 초기화 해줌)
        return f[n];
    }else{
        f[n] = fib(n-2)+fib(n-1); // 중간 계산 결과를 캐싱
        return f[n];
    }
}

int main(){

    int caseNum;
    cin>>caseNum;


    for(int i=0;i<caseNum;i++){
        int num;
        cin>>num;
        fill_n(f, num+1, 0);
        if(num==0) cout<<"1 0"<<endl;
        else if(num==1) cout<<"0 1"<<endl;
        else{
            fib(num);
            cout<<f[num-1]<<" "<<f[num]<<endl;
        } 
        
    }

    return 0;
}

