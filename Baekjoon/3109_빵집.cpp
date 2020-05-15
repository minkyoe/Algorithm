#include <iostream>
#define RMAX 10000
#define CMAX 500
using namespace std;

int R;
int C;
char map[RMAX][CMAX];

// 오른쪽 위 대각선, 오른쪽, 오른쪽 아래 대각선
int dirY[3] = {-1, 0, 1}; 
int dirX[3] = {1, 1, 1};

int visited[RMAX][CMAX] = {0,};

int dfs(int y, int x) {
    visited[y][x] = 1;

    if (x == C-1) {
        return 1;
    }

    for (int i=0; i<3; i++) {
        int tmpY = y + dirY[i];
        int tmpX = x + dirX[i];

        if (0<= tmpY && tmpY <R && 0<= tmpX && tmpX <C && map[tmpY][tmpX] != 'x' && !visited[tmpY][tmpX]) {
            if(dfs(tmpY, tmpX)) return 1;
        }
    }
    return 0;

}


int main(void) {

    cin >> R >> C;

    for (int i=0; i<R; i++) {
        for (int j=0; j<C; j++) {
            cin >> map[i][j];
        }
    }

    int answer = 0;

    for (int i=0; i<R; i++) {
        int tmp = dfs(i, 0);
        if (tmp == 1) answer++;
    }

    cout << "answer:: " << answer << endl;

  
}