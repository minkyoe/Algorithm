#include <iostream>
#include <algorithm>
#include <queue>
#define MAX 100000
int visited[MAX+1] = {0,};

// 조건문.. 진짜 중요.. position이 0보다 같거나 크고 MAX보다 같거나 작은게 포인트.....
// if 문 괄호. ... .... 실수 .............................다신하지마!!!!!

using namespace std;

int minTime(int N, int K)
{
    queue<int> posQueue;

    posQueue.push(N);
    visited[N] = 1;
    int minTime = 0;

    while (!posQueue.empty())
    {

        int size = posQueue.size();
        for (int i = 0; i < size; i++)
        {

            int curPos = posQueue.front();
            posQueue.pop();

            if (curPos == K)
                return minTime;
            else
            {
                if (curPos - 1 >= 0 && curPos - 1 <= MAX && !visited[curPos - 1]) {
                    posQueue.push(curPos - 1);
                    visited[curPos - 1] = 1;
                }
                if (curPos + 1 >= 0 && curPos + 1 <= MAX && !visited[curPos + 1]) {
                    posQueue.push(curPos + 1);
                    visited[curPos + 1] = 1;
                }
                if (curPos * 2 >= 0 && curPos * 2 <= MAX && !visited[curPos * 2]) {
                    posQueue.push(curPos * 2);
                    visited[curPos * 2] = 1;
                }
            }
        }
        minTime++;
    }
    return minTime;
}

int main(void)
{

    int N, K = 0;
    cin >> N >> K;
    int answer = minTime(N, K);

    cout << answer << endl;
    return 0;
}