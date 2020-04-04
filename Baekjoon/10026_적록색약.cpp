#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
#define MAX 100
using namespace std;

// DFS
// memset 헤더파일 -> cstring !!!!!!!!!!!!

int N = 0;
char graph[MAX][MAX];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int rgPsCnt = 0; // 적록색약인 사람이 보는 구역 개수
int notRgPsCnt = 0; // 적록색약이 아닌!!!!! 사람이 보는 구역 개수
bool visited[MAX][MAX] = {0,};


void dfs(int n, int m, char rgb){
    visited[n][m] = true;

    for (int i=0; i<4; i++) {
        int nx = n + dx[i];
        int ny = m + dy[i];

        if (0<= nx && nx < N && 0<= ny && ny < N) {
            if (!visited[nx][ny] && graph[nx][ny] == rgb) {
                 dfs(nx, ny, graph[nx][ny]);
            }
        } 
    }

}

int main(void)
{
    cin >> N;

    for (int i=0; i<N; i++) {
        for (int j=0; j<N; j++) {
            cin >> graph[i][j];
        }
    }

    // 적록색약이 아닌!!!!!!!! 사람이 보는 구역 개수 구하기
    for (int i=0; i<N; i++) {
        for (int j=0; j<N; j++) {
            if (!visited[i][j]) {
                dfs(i,j,graph[i][j]);
                notRgPsCnt ++;
            }
        }
    }

    // G를 R로 바꾸기
    for (int i=0; i<N; i++) {
        for (int j=0; j<N; j++) {
            if (graph[i][j] == 'G') {
                graph[i][j] = 'R';
            }
        }
    }

    memset(visited, 0, sizeof(visited)); // visited 배열 다시 0으로 초기화

    // 적록색약인 사람이 보는 구역 개수 구하기
    for (int i=0; i<N; i++) {
        for (int j=0; j<N; j++) {
            if (!visited[i][j]) {
                dfs(i,j,graph[i][j]);
                rgPsCnt ++;
            }
        }
    }

    cout << notRgPsCnt << endl;
    cout << rgPsCnt << endl;

    // graph 배열에 제대로 들어갔는지 출력해보기
    // for (int i=0; i<N; i++) {
    //     for (int j=0; j<N; j++) {
    //         cout << graph[i][j];
    //     }
    //     cout << endl;
    // }


    return 0;
}