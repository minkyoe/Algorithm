#include <iostream>
#include <cmath>
#include <cstdlib>

using namespace std;
typedef long long ll;

// 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 이루어져 있다.

// 한 줄에 x1, y1, r1, x2, y2, r2가 주어진다. x1, y1, x2, y2는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이고, r1, r2는 10,000보다 작거나 같은 자연수이다.

// 각 테스트 케이스마다 류재명이 있을 수 있는 위치의 수를 출력한다. 만약 류재명이 있을 수 있는 위치의 개수가 무한대일 경우에는 -1을 출력한다.


int main(){

    ll caseNum,x1, y1, x2, y2;
    ll d; // 두 원의 중점 사이의 거리
    ll r1,r2; // 두 원의 반지름 
    cin>>caseNum;

    while(caseNum--){
        cin>>x1>>y1>>r1>>x2>>y2>>r2;
        //cout<<"\n";
        // d = sqrt(pow(x2-x1,2) + pow(y2-y1,2));

        d = sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)));
// cout<<"distance: "<<d;
        if(x1==x2 && y1==y2){
            if(r1==r2) cout<<-1;
            else cout<<0;
        }         
        else if(d==r1+r2 || d==abs(r1-r2)) cout<<"1"<<endl;
        else if(d>r1+r2) cout<<"0"<<endl;
        else if(d==0) cout<<"-1"<<endl;
        else if(d>abs(r1-r2)&&d<(r1+r2))cout<<"2"<<endl; 
        
    }

}