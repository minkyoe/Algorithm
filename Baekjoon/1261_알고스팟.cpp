#include <iostream>
#include <stdio.h>
#include <deque>
#define MAX 101
using namespace std;

int N;
int M;
int map[MAX][MAX];
bool visited[MAX][MAX] = { false, };

int dirX[4] = { 0, 0, -1, 1 };
int dirY[4] = { -1, 1, 0, 0 };

int bfs(int y, int x) {
	deque<pair<pair<int, int>, int>> dq;
	dq.push_back(make_pair(make_pair(y, x), 0));
    int cnt = 0;
	while (!dq.empty()) {
		int ny = dq.front().first.first;
		int nx = dq.front().first.second;
		cnt = dq.front().second;
		dq.pop_front();
		visited[ny][nx] = true;

		if (ny == N && nx == M) {
			return cnt;
		}

		for (int i = 0; i < 4; i++)
		{
			int yy = ny + dirY[i];
			int xx = nx + dirX[i];

			if (1 <= yy && yy <= N && 1 <= xx && xx <= M && !visited[yy][xx])
			{

				if (map[yy][xx] == 1) {
					dq.push_back(make_pair(make_pair(yy, xx), cnt + 1));
					visited[yy][xx] = true;
				}
				else {
					dq.push_front(make_pair(make_pair(yy, xx), cnt));
					visited[yy][xx] = true;
				}
			}
		}
	}
    return cnt;
}


int main(void) {

	cin >> M >> N; // 가로, 세로

	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= M; j++)
		{
			scanf("%1d", &map[i][j]);
		}
	}

	cout << bfs(1, 1);

	return 0;
}