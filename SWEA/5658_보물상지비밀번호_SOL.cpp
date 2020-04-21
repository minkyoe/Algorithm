#include <iostream>
#include <map>
#include <vector>
#include <string>
#include <algorithm>
#define NMAX 28
using namespace std;

int N, K = 0; // 숫자 개수, 순서
string arr[NMAX] = {}; // 아무런 회전도 시키지 않은 초기 배열
vector<string> allNum = {}; // 중복된 숫자를 제외한 전체 숫자
vector<int> convertedNum = {}; // 10진수로 변환된 숫자
int cnt = 0; // 한변에 있는 숫자 개수

int isExist(string num) {
    for (int i=0; i<allNum.size(); i++) {
        if (allNum[i] == num) return 1;
        else if (i == allNum.size() - 1) return 0;
        else continue;
    }

    return 0;
}

int main(void) {

    cin >> N >> K;

    string tmp;
    cin >> tmp;

    for (int i=0; i<N; i++) {
        arr[i] = tmp.at(i);
    }

    cnt = N / 4;

    // 한 변에 있는 숫자개수만큼 회전
    for (int s=0; s<cnt; s++) { 
        // 원래 배열 복사
        string arrCopy[NMAX] = {}; 
        for (int j=0; j<N; j++) {
            arrCopy[j] = arr[j];
        }

        // 한칸씩 회전
        for (int r=0; r<N; r++) {
            arr[(r+1)%N] = arrCopy[r%N];
        }

        // cnt만큼 잘라서 숫자들 allNum배열에 넣기 (중복체크)
        for (int p=0; p<N; p=p+cnt) {
            string tmp = "";
            for (int a=p; a<p+cnt; a++) {
                tmp += arr[a];
                if (a == p+cnt-1) { 
                    if (!isExist(tmp)) allNum.push_back(tmp);
                }
            }
        }        
    }
    

    // 10진수로 변환해서 <10진수, 16진수> convertedNum에 넣기
    for (int k=0; k<allNum.size(); k++) {
        int tmp = stoi("0x" + allNum[k], NULL, 16);
        convertedNum.push_back(tmp);
    }

    sort(convertedNum.begin(), convertedNum.end(), greater<int>());

    cout << "answer:: " << convertedNum[K-1] ;


    
    return 0;
}

