#include <string>
#include <vector>
#include <map>
#include <queue>
#include <iostream>

using namespace std;

map<string, string> info; // {uid, nick}
vector<string> tmpInfo; // record 쪼개기 -> 0: "Enter", "Leave", "Change"     1: uid     2: nick

queue<string> tmpAns; // "uid Enter"

vector<string> solution(vector<string> record) {
    vector<string> answer;

    for(int i=0; i<record.size(); i++) {
        int emptyIdx = -1; // 공백이 나온 인덱스
        // 문자열 공백 기준으로 자르기
        for(int j=0; j<record[i].size(); j++) {
            if (record[i][j] == ' ') {
                string tmp = record[i].substr(emptyIdx+1, j-emptyIdx-1);
                tmpInfo.push_back(tmp);
                emptyIdx = j;
            }
            if (j == record[i].size()-1) {
                string tmp = record[i].substr(emptyIdx+1, j-emptyIdx);
                tmpInfo.push_back(tmp);
            }
        }

        // tmpAns에 "uid Enter" 이런식으로 넣기
        string uid = tmpInfo[1];
        string nick = tmpInfo[2];

        int status;
        if (tmpInfo[0] == "Enter") {
            status = 1;
            tmpAns.push(uid + " " + tmpInfo[0]);

        }
        else if (tmpInfo[0] == "Leave") {
            status = 0;
            tmpAns.push(uid + " " + tmpInfo[0]);
        }
        else {
            status = 2;
        }
       
        if (info.find(uid) != info.end()) { // 들어온적 있는 유저라면
            if (status == 2 || status == 1) info[uid] = nick; // 들어오면서 닉네임 바꾸거나 채팅방안에 있을 때 닉네임 바꿀 수 있음
        }
        else info.insert(make_pair(uid, nick)); // 새로운 유저라면
        
        tmpInfo.clear();
    }


    // uid -> nick , "Enter" -> "님이 들어왔습니다"로 변환해서 answer에 넣기
    while(!tmpAns.empty()){
        string tmp = tmpAns.front();
        tmpAns.pop();

        string uid;
        string status;
		
        // 문자열 공백 기준으로 자르기
        for(int i=0; i<tmp.size(); i++) {
            if (tmp[i] == ' ') {
                string uid = tmp.substr(0, i);
                string status = tmp.substr(i+1, tmp.size()-i);

                string nick = info[uid];
                string realStatus;
                if (status == "Enter") realStatus = "님이 들어왔습니다.";
                else if (status == "Leave") realStatus = "님이 나갔습니다.";

                string ans = nick + realStatus;
                answer.push_back(ans);
            }

        }
	}
    return answer;
}

int main(void) {

    vector<string> answer = solution({"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});

    for (int i=0; i<answer.size(); i++) {
        cout << answer[i] << endl;
    }

}