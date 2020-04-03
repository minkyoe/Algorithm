#include <iostream>
#include <cmath>
#include <cstdlib>
#include <stack>
#include <algorithm>
#define MAX 1001
using namespace std;
int isVisited[MAX] = {0};

void dfs(int array[MAX][MAX],int startNode,int N){
    if(isVisited[startNode]) return;
    isVisited[startNode]=1;

    for(int i=1; i<=N; i++){
        isVisited[startNode]=1;
        if(array[startNode][i]){
            dfs(array,i,N);
        }
    }
    
}

int main(){

    int n,m,max = 0; // N: 정점의 개수, M: 간선의 개수, max: 배열 크기를 정하기 위한 변수
    cin>>n>>m;

    int array[MAX][MAX];
    int startNode, toNode = 0;

    int cmpCount=0;
    int cmpFlag=false;

    for(int i=1;i<=m;i++){
        cin>>startNode>>toNode;
        array[startNode][toNode] = 1;   
        array[toNode][startNode] = 1;
    }
    for(int d=1;d<=n;d++){
        if(isVisited[d]) continue;
        dfs(array,d,n);
        cmpCount++;
    }

    cout<<cmpCount;


    return 0;
}

