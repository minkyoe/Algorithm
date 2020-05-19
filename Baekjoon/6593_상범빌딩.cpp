#include <iostream>
#include <cstring>
#include <queue>

#define MAX 30

using namespace std;

char map[MAX][MAX][MAX];
bool visited[MAX][MAX][MAX];
int L, R, C;
pair<pair<int, int>,int> start;
pair<pair<int, int>,int> finish;


// 동 서 남 북 상 하
int dy[6] = {0, 0, 1, -1, 0, 0};
int dx[6] = {1, -1, 0, 0, 0, 0};
int df[6] = {0, 0, 0, 0, -1, 1};

int bfs(pair<pair<int, int>,int> start) {
    queue<pair<pair<int, int>, pair<int, int>>> q;
    q.push(make_pair(make_pair(start.first.first, start.first.second), make_pair(start.second, 0)));

    while(!q.empty()) {
        int tmpF = q.front().first.first;
        int tmpY = q.front().first.second;
        int tmpX = q.front().second.first;
        int min = q.front().second.second;
        q.pop();
        

        if (tmpF == finish.first.first && tmpY == finish.first.second && tmpX == finish.second) {
            return min;
        }

        for (int i=0; i<6; i++) {
            int nextF = tmpF + df[i];
            int nextY = tmpY + dy[i];
            int nextX = tmpX + dx[i];

            if (0<= nextF && nextF <L && 0<= nextY && nextY <R && 0<= nextX && nextX <C) {
                if (!visited[nextF][nextY][nextX] && map[nextF][nextY][nextX] != '#') {
                    visited[nextF][nextY][nextX] = 1;
                    q.push(make_pair(make_pair(nextF, nextY), make_pair(nextX, min+1)));
                }
            }
        }
    }
    return -1;
}

int main(void) {

    while(true) {
        cin >> L >> R >> C;
        
        if (L==0 && R==0 && C==0) {
            cout << endl;
            break;
        }

        memset(visited, 0, MAX*MAX*MAX); // visited 배열 초기화!!!!!!!!!!!!!!!!! 3차원 배열이니까 MAX*MAX*MAX!!

        for (int i=0; i<L; i++) {
            for (int j=0; j<R; j++) {
                for (int k=0; k<C; k++) {
                    cin >> map[i][j][k];
                    if (map[i][j][k] == 'S') start = make_pair(make_pair(i,j),k);
                    else if (map[i][j][k] == 'E') finish = make_pair(make_pair(i,j),k);
                }
            }
        }


        visited[start.first.first][start.first.second][start.second] = 1;
        int result = bfs(start);

        if (result == -1) cout << "Trapped!" << endl;
        else cout << "Escaped in " << result << " minute(s)." << endl;

    }
    
}