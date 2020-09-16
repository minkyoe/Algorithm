#include <iostream>
#include <vector>
#include <queue>
#include <tuple>
#include <algorithm>
#define MAX 21
using namespace std;

int N; // 격자 크기
int M; // 승객 수
int oil; // 연료
int minDis = 500;
int minIdx = 0;
int dy[4] = {-1, 1, 0, 0};
int dx[4] = {0, 0, -1, 1};

int map[MAX][MAX];
int startY, startX; // 운전 시작 위치
struct Guest {
    int fromY;
    int fromX;
    int toY;
    int toX;
    int dis; // 택시와의 거리
};
vector<Guest> v;

bool cmp(const Guest &g1, const Guest &g2) {
    if (g1.dis < g2.dis) {
        return true;
    }
    else if (g1.dis == g2.dis) {
        if(g1.fromY < g2.fromY) {
            return true;
        } 
        else if (g1.fromY == g2.fromY) {
            if(g1.fromX < g2.fromX) {
                return true;
            } 
            else return false;
        }
        else return false;
    }
    else return false;
}

int bfs(int sy, int sx, int ey, int ex) {
    bool visited[MAX][MAX] = {false,};

    queue<tuple<int,int,int>> q;
    q.push(make_tuple(sy, sx, 0));
    visited[sy][sx] = true;

    while(!q.empty()) {
        int fy = get<0>(q.front());
        int fx = get<1>(q.front());
        int dis = get<2>(q.front());
        q.pop();

        if (fy == ey && fx == ex) {
            return dis;
        }

        for (int d = 0; d < 4; d++)
        {
            int ny = fy + dy[d];
            int nx = fx + dx[d];

            if (ny < 1 || ny > N || nx < 1 || nx > N) continue;
            if (visited[ny][nx]) continue;
            if(map[ny][nx] == 1) continue;
            visited[ny][nx] = true;
            q.push(make_tuple(ny,nx,dis+1));
        }
        
    }
    return -1;
}
int main(void) {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M >> oil;

    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= N; j++)
        {
            cin >> map[i][j];
        }
    }
    
    cin >> startY >> startX;

    for (int i = 0; i < M; i++)
    {
        Guest g;
        int fy, fx, ty, tx;
        cin >> fy >> fx >> ty >> tx;
        g.fromY = fy;
        g.fromX = fx;
        g.toY = ty;
        g.toX = tx;
        v.push_back(g);
    }

    while(true) {
        for (int i = 0; i < v.size(); i++)
        {
            v[i].dis = bfs(startY, startX, v[i].fromY, v[i].fromX);
        }
        sort(v.begin(), v.end(), cmp);


        // 이동, 연료 감소
        int tmpOil = bfs(startY, startX, v[0].fromY, v[0].fromX);
        oil -= tmpOil;
        if (oil < 0 || tmpOil == -1) {
            cout << "-1";
            return 0;
        }
        // 승객 있는쪽으로 택시 이동
        startY = v[0].fromY;
        startX = v[0].fromX;

        // 목적지로 이동, 연료 감소, 남은 연료 >= 0 이면 연료 충전
        int destOil = bfs(startY, startX, v[0].toY, v[0].toX);
        oil -= destOil;
        if (oil < 0 || destOil == -1) {
            cout << "-1";
            return 0;
        } else if (oil >= 0) {
            oil += destOil * 2;
        }
        // 택시 위치 이동, 목적지 도착한 승객은 삭제
        startY = v[0].toY;
        startX = v[0].toX;
        v.erase(v.begin());

        if (v.size() == 0) {
            cout << oil << "\n";
            break;
        }
    }
    

    return 0;
}