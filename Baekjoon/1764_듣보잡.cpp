#include <iostream>
#include <string>
#include <map>
using namespace std;

int N, M;
int ansCnt = 0;
map<string, bool> listenSee;

int main(void) {

    cin >> N >> M;

    for (int i=0; i<N; i++) {
        string name;
        cin >> name;
        listenSee.insert(make_pair(name, false));
    }

    for (int j=0; j<M; j++) {
        string name;
        cin >> name;
        map<string, bool>::iterator it = listenSee.find(name);
        if (it != listenSee.end()) (*it).second = true;   
    }
    
    map<string, bool>::iterator it = listenSee.begin();
    for (auto it=listenSee.begin(); it!=listenSee.end(); it++) {
        if (it->second) {
            ansCnt++;
        }
    }

    // 출력
    cout << ansCnt << endl;
    for (auto it=listenSee.begin(); it!=listenSee.end(); it++) {
        if (it->second) {
            cout << it->first << endl;
        }
    }

    return 0;
}