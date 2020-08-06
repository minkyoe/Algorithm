#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#include <stdlib.h>

using namespace std;

int comv = 0;             // 편의점 개수
int beer = 0;             // 남은 맥주 개수
vector<pair<int, int>> v; // 위치 좌표 벡터
bool visited[102];        // 편의점 최대 100개 + 상근 집 + 페스티벌
bool happyFlag = true;
int sy = 0;
int sx = 0; // 시작점

int cy = 0;
int cx = 0; // 편의점

int ty = 0;
int tx = 0; // 페스티벌

void bfs(int sy, int sx, int vIdx)
{
    queue<pair<pair<int, int>, int>> q;
    q.push(make_pair(make_pair(sy, sx), vIdx));
    visited[vIdx] = true;

    while (!q.empty())
    {
        int fromY = q.front().first.first;
        int fromX = q.front().first.second;
        int vId = q.front().second;
        q.pop();

        if (fromY == ty && fromX == tx) {
            happyFlag = true;
            return;
        }

        for (int i = 1; i <= comv + 1; i++) // 첫번째 편의점부터 페스티벌 장소까지
        {
            if (!visited[i] && (abs(fromY - v[i].first) + abs(fromX - v[i].second)) <= 1000) // 갈때까지 20병 다 먹을수 없고 방문한적이 없다면
            {
                q.push(make_pair(make_pair(v[i].first, v[i].second), i));
                visited[i] = true;
            } else {
                happyFlag = false;
            }
        }
    } // end of while
}

int main(void)
{
    int tc = 0;
    cin >> tc;

    while (tc--)
    {
        cin >> comv;
        v.clear();
        memset(visited, false, sizeof(visited));
        happyFlag = true;

        cin >> sy >> sx;
        v.push_back({sy, sx});

        for (int i = 1; i <= comv; i++)
        {
            cin >> cy >> cx;
            v.push_back({cy, cx});
        }

        cin >> ty >> tx;
        v.push_back({ty, tx});

        bfs(v[0].first, v[0].second, 0);

        if (!happyFlag)
            cout << "sad" << "\n";
        else
            cout << "happy" << "\n";
    }

    return 0;
}