#include <iostream>
#include <algorithm>
#include <vector>
#define MAX 100
using namespace std;

// DFS로 품
// 0 <= M,N,K <= 100

// 첫째 줄에 분리되어 나누어지는 영역의 개수를 출력한다. 둘째 줄에는 각 영역의 넓이를 오름차순으로 정렬하여 빈칸을 사이에 두고 출력한다.

int N, M, K = 0; // 가로, 세로, 직사각형 개수
int rec[MAX][MAX] = {0,}; // 직사각형에 해당하는 칸들
bool visited[MAX][MAX] = {0,}; // dfs 돌면서 방문했는지 체크
int cnt = 0; // 영역 넓이를 구하기 위한 개수
vector<int> result = {}; // 영역 넓이 push하여 정렬하고 출력 AND size 출력
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

void dfs(int x, int y) {
    visited[x][y] = true;
    cnt ++;

    for (int i=0; i<4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (0 <= nx && nx < M && 0 <= ny && ny < N) {
            if (!visited[nx][ny] && !rec[nx][ny]) {
                dfs(nx, ny);
            }
        }        
    }

}

int main(void)
{

    cin >> M >> N >> K;


    for (int i=0; i<K; i++) {
        int x1, y1, x2, y2 = 0;
        cin >> x1 >> y1 >> x2 >> y2;

        // 직사각형 사이에 있는 점들 checked
        for (int y=y1; y<y2; y++) {
            for (int x=x1; x<x2; x++) { // 좌표보다 하나씩 덜 받아야함 (배열은 점단위로 체크하는게 아니라 칸단위니까 -> 그려보면 앎)
                rec[y][x] = 1; // 우리가 사용하는 배열은 문제에 나와있는 배열과 x축 y축 반대임 !! 
            }
        }
    }
    
    // EX) M=5, N=7
    for (int k=0; k<M; k++) {
        for (int h=0; h<N; h++) {
            if (!visited[k][h] && !rec[k][h]) {
                cnt = 0;
                dfs(k,h);
                result.push_back(cnt);
            }
        }
    }

    cout << result.size() << endl;

    sort(result.begin(), result.end());

    for (int a=0; a<result.size(); a++) {
        cout << result[a] << " " ;
    }

    // 직사각형 점들 잘 check되었는지 출력해보기
    // for (int x=0; x<MAX; x++) {
    //     for (int y=0; y<MAX; y++) {
    //         if (rec[x][y] == 1) {
    //             cout << x << " " << y << endl;
    //         }
    //     }
    // }

    return 0;
}