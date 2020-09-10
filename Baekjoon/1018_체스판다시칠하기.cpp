#include <iostream>
#include <queue>
#define MAX 50
#define SIZE 8

using namespace std;

int N, M; // 세로, 가로
char map[MAX+1][MAX+1];
int ans = 64; // 다시 칠해야하는 정사각형의 개수 최소값
int changeCnt = 0;
int dr[] = {-1, 1, 0, 0};
int dc[] = {0, 0, -1, 1};

void bfs(int r, int c, char tmp[SIZE][SIZE]) {
    char board[SIZE][SIZE];
    for (int i = 0; i < SIZE; i++)
    {
        for (int j = 0; j < SIZE; j++)
        {
            board[i][j] = tmp[i][j];
        }
    }
    
    bool visited[MAX+1][MAX+1] = {false,};
    queue<pair<int,int>> q;
    q.push({r,c});
    visited[r][c] = true;

    while (!q.empty())
    {
        int tr = q.front().first;
        int tc = q.front().second;
        char now = board[tr][tc];
        q.pop();

        for (int d = 0; d < 4; d++)
        {
            int nr = tr + dr[d];
            int nc = tc + dc[d];
            char next = board[nr][nc];
            if (nr < 0 || nr >= SIZE || nc < 0 || nc >= SIZE) continue;
            if (visited[nr][nc]) continue;

            visited[nr][nc] = true;
            q.push({nr,nc});
            if (now == next) {
                if (now == 'B') board[nr][nc] = 'W';
                else board[nr][nc] = 'B';
                ++changeCnt;
            }
           
        }
    }

    
    
}
void check(int startR, int startC) {
    char tmp[SIZE][SIZE];
    char tmpCopy[SIZE][SIZE];
    for (int i = startR; i < startR + SIZE; i++)
    {
        for (int j = startC; j < startC + SIZE; j++)
        {
            tmp[i-startR][j-startC] = map[i][j];
            tmpCopy[i-startR][j-startC] = map[i][j];
        }
    }

    // W
    if (tmp[0][0] == 'B') {
        ++changeCnt;
        tmp[0][0] = 'W';
    } 
    bfs(0,0,tmp);

    // ans 값 비교
    ans = ans > changeCnt ? changeCnt : ans;

    // 초기화
    for (int i = 0; i < SIZE; i++)
    {
        for (int j = 0; j < SIZE; j++)
        {
            tmp[i][j] = tmpCopy[i][j];
        }
    }
    changeCnt = 0;

    // B
    if (tmp[0][0] == 'W') {
        ++changeCnt;
        tmp[0][0] = 'B';
    }
    bfs(0,0,tmp);

    // ans 값 비교
    ans = ans > changeCnt ? changeCnt : ans;
    
    // 초기화
    changeCnt = 0;
}
int main(void){

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            cin >> map[i][j];
        }
    }


    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (i+SIZE <= N && j+SIZE <= M) {
                check(i,j); // i,j에서 8x8 잘라서 확인
            }
        }
    }

    cout << ans;

    return 0;
}