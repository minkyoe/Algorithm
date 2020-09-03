#include <iostream>
#include <queue>
using namespace std;

int N; // 연산 개수

int main(void) {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> N;
    priority_queue<int, vector<int>, greater<int>> pq; // 최소힙

    for (int i = 0; i < N; i++)
    {
        int mode = 0;
        cin >> mode;

        if (mode != 0) { //  배열에 x 추가
            int x = mode;
            pq.push(x);
        }
        else { // 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거
            if (pq.size() == 0) cout << "0" << "\n";
            else {
                cout << pq.top() << "\n";
                pq.pop();
            }
        }
    }

    return 0;
}