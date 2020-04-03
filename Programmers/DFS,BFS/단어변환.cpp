#include <string>
#include <vector>
#include <iostream>

// 미완!!!!!!!!!!!!!!!!
using namespace std;
int answer = 0;
int visited[50];
void dfs(string begin, string target, vector<string> words, int index, int count) {
    int sameCount = 0;
    answer ++;
    cout << "index:: " << index << endl;
    cout << "네,,?" << endl;
    if (count == words.size()) {
        if (begin == target) {
            cout << "begin == target" << endl;
            return;
        }

        else{
            answer = 0;
            cout << "this is ELSE!!" << endl;
        }
    }

    for (int j = 0; j < words.size(); j++) {
        string temp = words[j];
        for (int i = 0; i < begin.size(); i++) {
            int idx = temp.find(begin.substr(i,1));
            if (idx>=0) {
                // words[j] = words[j].substr(0,idx) + words[j].substr(idx+1);
                temp = temp.substr(0,idx) + temp.substr(idx+1);
                sameCount ++;
            } else continue;
        }
        if (sameCount == 2 && !visited[j]) {
            dfs(words[j], target, words, j, count+1);
            visited[j] = 1;
            cout << "dfs:: " << words[j] << endl;
        }

        // else {
        //     if (j == words.size()-1) return;
        // }

        // if (sameCount == 2 && !visited[j]) {
        //     dfs(words[j], target, words, j, count+1);
        //     visited[j] = 1;
        //     cout << "dfs:: " << words[j] << endl;
        // }
    }

}


int solution(string begin, string target, vector<string> words)
{
    // int sameCount = 0;

    // for (int j = 0; j < words.size(); j++) {
    //     for (int i = 0; i < begin.size(); i++) {
    //         int idx = words[j].find(begin.substr(i,1));
    //         if (idx>=0) {
    //             words[j] = words[j].substr(0,idx) + words[j].substr(idx+1);
    //             sameCount ++;
    //         } else continue;
    //     }
    //     if (sameCount == 2) {

    //     }
    // }

    dfs(begin, target, words, 0, 0);

    cout << "answer:: " << answer;
    return answer;
}

int main(void)
{

    solution("hit", "cog", {"hot", "dot", "dog", "lot", "log", "cog"});
    // cout << "answer:: " << real_answer;
    return 0;
}