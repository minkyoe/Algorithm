#include <iostream>
#include <vector>
using namespace std;

// DFS, 싸이클 (어려웠슴 복습 필요!!!!!!!!!!!!!!!!!!!)

int k;
vector<int> floor;
vector<int> above;
vector<int> aboveVisited;
vector<int> answer;


void dfs(int startNode, int nowNode) {
    if (aboveVisited[nowNode] == 1) {
       if (startNode == nowNode) {
            answer.push_back(startNode);
        }
        else return;
    } else {
        aboveVisited[nowNode] = 1;
        dfs(startNode, floor[nowNode]);
        return;
    }
}

int main(void)
{

    cin >> k;

    floor = vector<int> (k+1, 0);
    above = vector<int> (k+1, 0);
    
    for (int i=1; i<=k; i++) {
        cin >> floor[i]; 
        above[i] = i;
    }
    
    aboveVisited = vector<int> (k+1, 0);

    for (int j=1; j<=k; j++) {
        dfs(j, j);
        aboveVisited = vector<int> (k+1, 0);
    }
  
    cout << answer.size() << endl;
    for (int j=0; j<answer.size(); j++) {
        cout << answer[j] << endl;
    }

  
}

