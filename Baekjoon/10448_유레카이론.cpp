#include <iostream>
#include <vector>

using namespace std;

// 브루트 포스
// 3중 포문 (dfs로 조합 풀려한 ㄴㅏ.. 반성.. 넘 복잡..)

int samgaksu[45];
vector<int> answers;

void solution(int num) {
    for (int i=0; i<45; i++) {
        for (int j=0; j<45; j++) {
            for (int k=0; k<45; k++) {
                if (samgaksu[i] + samgaksu[j] + samgaksu[k] == num) {
                    answers.push_back(1);
                    return;
                }
            }
        }
    }
    answers.push_back(0);
}

int main(void)
{

    int k; int num;
    cin >> k;

    // 삼각수 배열 초기화
    for (int s=0; s<45; s++) {
        samgaksu[s] = (s+1)*(s+2)/2;
    }

    for (int i=0; i<k; i++) {
        cin >> num;
        solution(num);
    }

    for (int a=0; a<answers.size(); a++) {
        cout << answers[a] << endl;
    }

    return 0;
}