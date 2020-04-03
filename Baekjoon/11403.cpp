#include <iostream>
#include <cmath>
#include <cstdlib>
#include <stack>
#define MAX 101
using namespace std;


void dfs (int array[MAX][MAX],int startNode,int N){
    int isVisited[MAX] = {0};

    stack<int> nodes;
    nodes.push(startNode);

    while(nodes.size()){
        int top = nodes.top();
        nodes.pop();

        for(int toNode=0; toNode<N; toNode++){
            if(isVisited[toNode]==0 && array[top][toNode]==1){
                nodes.push(toNode);
                isVisited[toNode] = 1;
            }
        }
    }

    for(int arrIdx=0; arrIdx<N; arrIdx++){
        if(isVisited[arrIdx]){
            array[startNode][arrIdx] = 1;
        }
    }
}

int main(){

    int N = 0; // N: 정점의 개수
    int array[MAX][MAX]; // 처음에 입력받은 뒤 다시 갱신해서 출력해줘야 할 배열

    cin>>N;

    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            cin>>array[i][j]; // 배열 입력받기
        }
    }
    for(int d=0;d<N;d++){
        dfs(array,d,N);
    }

    for(int c=0;c<N;c++){
        for(int d=0;d<N;d++){
            cout<<array[c][d]<<" "; // 갱신 된 배열 출력하기
        }
        cout<<endl;
    }

    return 0;
}

