#include <string>
#include <vector>
#include <iostream>


// 각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다. ==> 여기서 sameCount == 2 이렇게 하니까 계속 틀림.. 바보냐고.... 같지않은숫자를 세줘야지!!!
using namespace std;
int answer = 50;
int visited[50] = {0,};
void dfs(string begin, string target, vector<string> words, int index, int count) {

    for (int j = 0; j < words.size(); j++) {
        int diffCnt = 0;

        for (int i = 0; i < words[i].size(); i++) {
            if (begin[i] != words[j][i]) diffCnt ++;
        }

        if (diffCnt == 1 && !visited[j]) {
            if (target == words[j] && answer > count + 1) {
                answer = count + 1;
                return;
            }
            visited[j] = 1;
            dfs(words[j], target, words, j, count+1);
            visited[j] = 0;
        }

    }

}


int solution(string begin, string target, vector<string> words)
{
    dfs(begin, target, words, 0, 0);
    if (answer == 50) answer = 0;

    cout << "answer:: " << answer;
    return answer;
}

int main(void)
{

    // solution("hit", "cog", {"hot", "dot", "dog", "lot", "log", "cog"});
    solution("hot","lot",{"hot", "dot", "dog", "lot", "log"});
    // cout << "answer:: " << real_answer;
    return 0;
}


