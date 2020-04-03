#include <iostream>
#include <cstdlib>
#include <string>
#include <queue>

using namespace std;
/*
push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/

int main(){

    queue<int> q;

    int N=0; // 명령의 수
    cin>>N;


    string order="";// 명령
    int num=0; // 명령과 함께 쓰인 숫자
    
    for(int i=0; i<N; i++){
        cin>>order; // 명령 받기
        if(order == "push"){
            cin>>num;
            q.push(num);
        }
        else if(order == "pop"){
            if(q.size()==0) cout<<-1<<endl;
            else{
                cout<<q.front()<<endl;
                q.pop();
            }
        }
        else if(order == "size"){
            cout<<q.size()<<endl;
        }
        else if(order == "empty"){
            if(q.size()==0) cout<<1<<endl;
            else cout<<0<<endl;
        }
        else if(order == "front"){
            if(q.size()==0) cout<<-1<<endl;
            else cout<<q.front()<<endl;
        }
        else if(order == "back"){
            if(q.size()==0) cout<<-1<<endl;
            else cout<<q.back()<<endl;
        }
    }
    
    return 0;
}

