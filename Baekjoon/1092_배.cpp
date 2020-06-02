#include <iostream>
#include <vector>
#include <algorithm>

// vector.erase(~~~~)

using namespace std;

int N, M; // 크레인 수, 박스 수
int minCrane = 1000000;
int maxCrane = 0;

vector<int> crane;
vector<int> box;

int main(void) {
    cin.tie(NULL);
    std::ios::sync_with_stdio(false);

    cin >> N;
    for (int i=0; i<N; i++) {
        int tmp;
        cin >> tmp;
        crane.push_back(tmp);
    }

    cin >> M;
    for (int i=0; i<M; i++) {
        int tmp;
        cin >> tmp;
        box.push_back(tmp);
    }

    sort(crane.begin(), crane.end(), greater<int>());
    sort(box.begin(), box.end(), greater<int>());

    int idx = 0;
    if (crane[idx] < box[idx]) {
        cout << "-1" << endl;
        return 0;
    }

    while (true) {
        idx++;
        for (int i=0; i<N; i++) { // 크레인
            for (int j=0; j<box.size(); j++) { // 박스
                if (crane[i] >= box[j]) {
                    box.erase(box.begin()+j, box.begin()+j+1);
                    break;
                }
            }
        }
        if (!box.size()) break;
    }
    cout << idx << endl;
    return 0;
}
