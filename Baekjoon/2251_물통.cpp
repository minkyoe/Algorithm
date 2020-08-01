#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <cstring>
#define MAX 200
using namespace std;

struct water {
    int A;
    int B;
    int C;
}; // 세개의 물통에 남아있는 물의 양

int A, B, C;
queue<water> q;
vector<int> ans;
int ansIdx = 0;
int visited[MAX+1][MAX+1][MAX+1];

int main(void) {
    memset(visited, 0, sizeof(visited));
    cin >> A >> B >> C;
    q.push({0, 0, C});

    while (!q.empty()) {
        int nowA = q.front().A;
        int nowB = q.front().B;
        int nowC = q.front().C;
        q.pop();

        if (visited[nowA][nowB][nowC] == 1) {
            continue;
        }

        visited[nowA][nowB][nowC] = 1;

        // 물통 첫번째가 비어있을경우 ans에 값 붙이기
        if (nowA == 0) {
            ans.push_back(nowC);
        }

        // A -> B
        if (nowA + nowB > B) {
            q.push({nowA-(B-nowB), B, nowC});
        } else {
            q.push({0, nowB+nowA, nowC});
        }

        // A -> C
        if (nowA + nowC > C) {
            q.push({nowA-(C-nowC), nowB, C});
        } else {
            q.push({0, nowB, nowC+nowA});
        }

        // B -> A
        if (nowB + nowA > A) {
            q.push({A, nowB-(A-nowA), nowC});
        } else {
            q.push({nowA+nowB, 0, nowC});
        }

        // B -> C
        if (nowB + nowC > C) {
            q.push({nowA, nowB-(C-nowC), C});
        } else {
            q.push({nowA, 0, nowC+nowB});
        }

        // C -> A
        if (nowC + nowA > A) {
            q.push({A, nowB, nowC-(A-nowA)});
        } else {
            q.push({nowA+nowC, nowB, 0});
        }

        // C -> B
        if (nowC + nowB > B) {
            q.push({nowA, B, nowC-(B-nowB)});
        } else {
            q.push({nowA, nowB+nowC, 0});
        }
    } // end of while

    sort(ans.begin(), ans.end(), less<int>());
    for (int i = 0; i < ans.size(); i++)
    {
        cout << ans[i] << " ";
    }
    
    
    return 0;
}