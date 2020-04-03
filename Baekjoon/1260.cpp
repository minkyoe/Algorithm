#include <iostream>
#include <cmath>
#include <cstdlib>
#include <queue>
#include <algorithm>
#include <array>
#define MAX 1002
using namespace std;
int isDfsVisited[MAX] = {0};
int isBfsVisited[MAX] = {0};

void dfs(int array[MAX][MAX],int start_node,int N){

    isDfsVisited[start_node]=1;
    cout<<start_node<<" ";

    for(int i=1; i<=N; i++){
        if(array[start_node][i] && isDfsVisited[i]==0){
            dfs(array,i,N);
        }
    }
    return;
}

void bfs(int array[MAX][MAX],int start_node,int N){
    queue<int> q;
    q.push(start_node);

    while(q.size()){
        int now_node = q.front();
        if(!isBfsVisited[now_node]) {
            cout<<now_node<<" ";
            isBfsVisited[now_node]=1;
        }
        q.pop();

        for(int i=1; i<=N; i++){
            if(array[now_node][i] && isBfsVisited[i]==0){
                q.push(i);
                cout<<i<<" ";
                isBfsVisited[i]=1;
            }
        }
    }

    

}

int main(){

    int nodes,lines,start_node = 0; // 정점의 개수, 간선의 개수, 탐색을 시작할 정점의 번호
    cin>>nodes>>lines>>start_node;

    int array[MAX][MAX] = {0};
    int from_node, to_node = 0;

    for(int i=1;i<=lines;i++){
        cin>>from_node>>to_node;
        array[from_node][to_node] = 1;   
        array[to_node][from_node] = 1;
    
    }
    
    dfs(array,start_node,nodes);
    cout<<endl;
    bfs(array,start_node,nodes);

    return 0;
}

