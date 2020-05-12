#include <iostream>
#include <vector>

#define MAX 13

using namespace std;

int k;
int printS[MAX] = {0,};
int visited[MAX] = {0,};

void dfs(int start, int count, vector<int>& S) {

    if (count == 6) {
        for (int j=0; j<6; j++) {
            cout << printS[j] << " ";
        }
        cout << endl;
        return;
    }

    for (int j=start; j<k; j++) { // k를 S.size()로 하면 안됨...
        printS[count] = S[j];
        visited[j] = 1;
        dfs(j+1, count+1, S);
        visited[j] = 0;
        
    }


}

int main(void)
{

    while (true) {
        cin >> k;
        if (k == 0) break;
       
        vector<int> S(k);
        for (int i=0; i<k; i++) {
            cin >> S[i];
        }

        visited[0] = 1;
        dfs(0, 0, S);
        visited[0] = 0;
        cout << endl; // 출력형식 !!! (각 테스트 케이스 마다 한줄씩 띄는거)
    }

    return 0;
}