#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<string> words, vector<string> queries) {
    vector<int> answer;
    for (int i=0; i<queries.size(); i++) {
        string s = queries[i];
        int idx = -1;
        int qCount = 0; // 물음표 갯수
        string query = "";
        int sameCount = 0;

        if (s.find_first_of("?") == 0) { // ???fro
            idx = s.rfind("?"); // 마지막 ? 인덱스
            query = s.substr(idx+1);
            qCount = idx + 1;

            for (int j=0; j<words.size(); j++) {
                string word = words[j];

                string tmp = word.substr(qCount);
                int size = word.size() - tmp.size();

                if (tmp == query && size == qCount) sameCount ++;
            }
            answer.push_back(sameCount);

            
        } else { // fro???
            idx = s.find("?"); // 첫번째 ? 인덱스
            query = s.substr(0, idx);
            qCount = s.size() - idx;

            for (int j=0; j<words.size(); j++) {
                string word = words[j];

                string tmp = word.substr(0, query.size());
                int size = word.size() - tmp.size();

                if (tmp == query && size == qCount) sameCount ++;
            }
            answer.push_back(sameCount);

        }
    }
    return answer;
}

int main(void) {

    vector<int> answer;


    answer = solution({"frodo", "front", "frost", "frozen", "frame", "kakao"}, {"?????"});

    for (int i=0; i<answer.size(); i++) {
        cout << answer[i] << " ";
    }
}