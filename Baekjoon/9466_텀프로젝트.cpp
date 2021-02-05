#include <iostream>
#include <vector>
using namespace std;


vector<int> stuChoice;
vector<int> teamStu; // 팀을 이룬 학생들
vector<int> visited;
int answer;



// void dfs(int start, int now) {
//     if (visited[start]) {
//         if (start == now) {
//             return;
//         }
//     } else {
//         visited[start] = 1;
//         dfs(start, stuChoice[now]);
//         // teamStu.push_back(now);
//         return;
//     }
// }

bool dfs(int start, int now) {
    if (visited[start]) {
        if (start == now) {
            return true;
        } else return false;
    } else {
        visited[start] = 1;
        if (dfs(start, stuChoice[now])) {
            teamStu.push_back(stuChoice[now]);
            return true;
        }
    }

        return false;

}

int main(void) {
    int k;
    cin >> k;

    for (int t=0; t<k; t++) {
        int stu;
        cin >> stu;

        stuChoice = vector<int> (stu+1);
        visited = vector<int> (stu+1, 0);
        answer = 0;

        for (int s=1; s<=stu; s++) {
            cin >> stuChoice[s];
        }

        // 먼저, 자기자신을 택한 학생들 골라내기
        for (int i=1; i<=stu; i++) {
            if (i == stuChoice[i]) {
                teamStu.push_back(i);
                // visited[i] = 1;
            }
        }

        for (int j=1; j<=stu; j++) {
            if (dfs(j, j)) {
                for (int b=1; b<=stu; b++) {
                    cout << "visited[" <<b<<"]:  " << visited[b] << endl;
                    if(visited[b]) teamStu.push_back(b);
                }
                visited = vector<int> (stu+1, 0);
                // teamStu.push_back(j);
            }
            // dfs(j, j);
            // for (int b=1; b<=stu; b++) {
            //     cout << "visited[" <<b<<"]:  " << visited[b] << endl;
            //     if(visited[b]) teamStu.push_back(b);
            // }
            // visited = vector<int> (stu+1, 0);

            // visited = vector<int> (stu+1, 0);
            // if (!visited[j]) {
            //     dfs(j, j);
            // }
        }

        // teamStu에 없는 학생들만 count
        for (int j=1; j<=stu; j++) {
            for (int a=0; a<teamStu.size(); a++) {
                cout << teamStu[a] << " ";
                if (j == teamStu[a]) continue;
                else if (a == teamStu.size()-1) {
                    answer++;
                }
            }
            // if (!visited[j]) answer++;
        }

        cout << "answer:: " << answer << endl;
    }

  
}

