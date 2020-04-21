#include <iostream>
#include <queue>
#define MAG_COUNT 4
#define WHEEL_COUNT 8
using namespace std;

int K = 0;  // 자석을 회전시키는 횟수. 1 이상 20이하
int arrCopy[MAG_COUNT][WHEEL_COUNT] = {};
int magWheel[MAG_COUNT][WHEEL_COUNT] = {}; // 각 자석의 날 자성정보. N극 = 0, S극 = 1. 시계방향 순
int rotationInfo[20][2] = {}; // 1 <= K <= 20 이므로.
int answer = 0;
int visited[MAG_COUNT] = {0,};

void rotate(int idx, int dir) {

    visited[idx] = 1;

    // 현재 자석 배열 copy
    int copy[1][8] = {};
    for (int i=0; i<WHEEL_COUNT; i++) {
        copy[0][i] = magWheel[idx][i];
    }

    // 방향에 맞게 한칸씩 옮기기
    for (int j=0; j<WHEEL_COUNT; j++) {
        if (dir == 1) magWheel[idx][(j+1)%WHEEL_COUNT] = copy[0][j%WHEEL_COUNT];
        if (dir == -1) magWheel[idx][(WHEEL_COUNT-j)%WHEEL_COUNT] = copy[0][(WHEEL_COUNT-j+1)%WHEEL_COUNT];
    }
    
}

void dfs(int idx, int dir) {

        rotate(idx, dir);

        for (int mag=0; mag<2; mag++) { // 양옆 두번
            if (0<= idx-1 && !visited[idx-1]) { // 지금 자석보다 앞에 있는 자석이 있고 방문한적없다면
                if (arrCopy[idx-1][2] != arrCopy[idx][6]) dfs(idx-1, dir*-1); // 맞물리는 부분의 극이 다른지 비교해서 다르면
            }
            if (idx+1 < 4 && !visited[idx+1]) { // 지금 자석보다 뒤에 있는 자석이 있다면
                if (arrCopy[idx+1][6] != arrCopy[idx][2]) dfs(idx+1, dir*-1); // 맞물리는 부분의 극이 다른지 비교해서 다르면
            } 
        }
    
}


void getAnswer() {
    if (magWheel[0][0] == 1) answer += 1;
    if (magWheel[1][0] == 1) answer += 2;
    if (magWheel[2][0] == 1) answer += 4;
    if (magWheel[3][0] == 1) answer += 8;
}

void mainFunc() {
	// 자석 배열 copy
			for (int i=0; i<MAG_COUNT; i++) {
				for (int j=0; j<WHEEL_COUNT; j++) {
					arrCopy[i][j] = magWheel[i][j];
				}
			}  

    for (int rcnt=0; rcnt<K; rcnt++) {
        int rmag = rotationInfo[rcnt][0]; // 회전시켜야 할 자석
        int rdir = rotationInfo[rcnt][1]; // 회전시킬 방향. 1=시계방향, -1=반시계방향

        visited[rmag-1] = 1;
       dfs(rmag-1, rdir);
           
        // 자석 배열 copy
        for (int i=0; i<MAG_COUNT; i++) {
            for (int j=0; j<WHEEL_COUNT; j++) {
                arrCopy[i][j] = magWheel[i][j];
            }
        }  

        // visited 초기화
        for (int i=0; i<MAG_COUNT; i++) {
            visited[i] = 0;
        }
    }
}

int main(int argc, char** argv)
{
	int test_case;
	int T;
	/*
	   아래의 freopen 함수는 input.txt 를 read only 형식으로 연 후,
	   앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
	   //여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
	   freopen 함수를 이용하면 이후 cin 을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
	   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 함수를 사용하셔도 좋습니다.
	   freopen 함수를 사용하기 위해서는 #include <cstdio>, 혹은 #include <stdio.h> 가 필요합니다.
	   단, 채점을 위해 코드를 제출하실 때에는 반드시 freopen 함수를 지우거나 주석 처리 하셔야 합니다.
	*/
	//freopen("input.txt", "r", stdin);
	cin>>T;
	/*
	   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
	*/
	for(test_case = 1; test_case <= T; ++test_case)
	{
		answer = 0;
		/////////////////////////////////////////////////////////////////////////////////////////////
		/*
			 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
		 */
		/////////////////////////////////////////////////////////////////////////////////////////////

		cin >> K ;

		for (int i=0; i<MAG_COUNT; i++) {
			for (int j=0; j<WHEEL_COUNT; j++) {
				cin >> magWheel[i][j];
			}
		}

		for (int k=0; k<K; k++) {
			for (int j=0; j<2; j++) {
				cin >> rotationInfo[k][j];
			}
		}
		mainFunc();

		getAnswer();

		cout << "#" << test_case << " " << answer << endl;

	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}