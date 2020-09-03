#include <iostream>
#include <queue>

using namespace std;

int N; // 연산 개수

int main(void) {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;

    priority_queue<int, vector<int>, less<int>> pq;

    for (int i = 0; i < N; i++)
    {
        int mode = -1;
        cin >> mode;

        if (mode != 0) {
            pq.push(mode);
        } else {
            if (pq.size() == 0) cout << "0" << "\n";
            else {
                cout << pq.top() << "\n";
                pq.pop();
            }
        }
    }
    
    return 0;
}