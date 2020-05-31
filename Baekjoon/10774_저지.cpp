#include <iostream>
#include <vector>

// 이미 한 선수에게 제공되었는지 체크!

using namespace std;

vector<pair<char, int>> require;
vector<pair<char, bool>> jersey;
int r, j;
int answer = 0;

int main(void) {
    cin >> j;
    cin >> r;

    jersey = vector<pair<char, bool>> (j);
    require = vector<pair<char, int>> (r);

    for (int i=0; i<j; i++) {
        char size;
        cin >> size;
        jersey[i] = make_pair(size, false);
    }

    for (int i=0; i<r; i++) {
        char tmp;
        int cnt;
        cin >> tmp >> cnt;
        require[i] = make_pair(tmp, cnt);
    }

    for (int i=0; i<r; i++) {
        char rSize = require[i].first;
        int rIdx = require[i].second;

        char jSize = jersey[rIdx-1].first;
        bool isProvided = jersey[rIdx-1].second;

        if (!isProvided) {
            if (rSize == 'S') {
                if (jSize == 'S' || jSize == 'M' || jSize == 'L') {
                    answer++;
                    jersey[rIdx-1].second = true;
                }
            }
            else if (rSize == 'M') {
                if (jSize == 'M' || jSize == 'L') {
                    answer++;
                    jersey[rIdx-1].second = true;
                }
            }
            else if (rSize == 'L') {
                if (jSize == 'L') {
                    answer++; 
                    jersey[rIdx-1].second = true;
                }
            }
            else continue;
        }
        else continue;
        
    }


    cout << answer << endl;

}