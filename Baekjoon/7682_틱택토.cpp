#include <iostream>
#include <cstring>
#include <string>
#include <vector>

using namespace std;

char map[3][3];
int xCnt, oCnt, eCnt;

int check (char c) {
    int cnt = 0;
    
    // 가로, 세로
    for(int i = 0 ; i < 3 ; i++) {
        if(map[i][0] == c && map[i][0] == map[i][1] && map[i][1] == map[i][2]) cnt++;
        if(map[0][i] == c && map[0][i] == map[1][i] && map[1][i] == map[2][i]) cnt++;
    }
    // 대각선
    if(map[0][0] == map[1][1] && map[1][1] == map[2][2] && map[0][0] == c) cnt++;
    if(map[0][2] == map[1][1] && map[1][1] == map[2][0] && map[0][2] == c) cnt++;

    return cnt;
}

int main(void) {

    string tmp;

    while (true) {
        cin >> tmp;

        if (tmp == "end") break;
        memset(map, 0, 9);
        xCnt = 0;
        oCnt = 0;
        eCnt = 0;

        int strIdx = 0;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {        
                map[i][j] = tmp[strIdx++];
            
                if (map[i][j] == 'X') xCnt++;
                else if (map[i][j] == 'O') oCnt++;
                else eCnt++;
            }
        }

        if (xCnt - oCnt > 1 || xCnt < oCnt ) {
            cout << "invalid" << endl;
            continue;
        }

        // 빈칸 없이 다 참
        if (eCnt == 0) {
            if (xCnt-oCnt == 1 && check('O') == 0) cout << "valid" << endl;
            else cout << "invalid" << endl;
        }

        // 빈칸 있음
        else { 
            if (xCnt == oCnt) { // x와 o의 개수 같으면 o가 한줄 만들어져서 끝났다는거니까 o로 한줄만들어졌는지 검사
                if (check('O') == 1) cout << "valid" << endl;
                else cout << "invalid" << endl;
            }
            else if (xCnt > oCnt) { // x가 한줄 만들어져서 끝났다는거니까 x로 한줄만들어졌는지 검사
                if (check('X') != 0 && xCnt-oCnt == 1) cout << "valid" << endl;
                else cout << "invalid" << endl;
            }
        }
     
    }
    return 0;
} 

