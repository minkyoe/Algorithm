#include <iostream>
#include <queue>
#define WMAX 12
#define HMAX 15

using namespace std;

// 중복순열, dfs
/*
① 구슬은 좌, 우로만 움직일 수 있어서 항상 맨 위에 있는 벽돌만 깨트릴 수 있다.

② 벽돌은 숫자 1 ~ 9 로 표현되며,
   구술이 명중한 벽돌은 상하좌우로 ( 벽돌에 적힌 숫자 - 1 ) 칸 만큼 같이 제거된다.

*** 최대한 많은 벽돌을 깨트려서 "최소 벽돌 개수 구하기"

==>   총 열의 갯수에서 구슬의 갯수만큼 중복순열로 뽑아서 완전탐색을 진행

*/

struct Node {
    int h;
    int w;
    int num;
    Node(int x, int y, int z): h(x), w(y), num(z){} // struct Node 생성자 
};

int answer;
int N, W, H = 0; // 구슬 쏘는 횟수, 가로, 세로
int arr[HMAX][WMAX] = {0,};
queue<Node> q;

// 상, 하, 좌, 우
int dirW[4] = {0, 0, -1, 1};
int dirH[4] = {-1, 1, 0, 0}; 

void getAnswer() {
    int tmp = 0;
     for (int i=0; i<H; i++) {
        for (int j=0; j<W; j++) {
            if (arr[i][j] != 0) tmp += 1;
        }
    }
    answer = tmp < answer ? tmp : answer;
}


// 빈칸 없애면서 칸 밀기
void sort(int arr[HMAX][WMAX]) {

    for(int w=0; w<W; w++) {
        int bCnt = 0; // 벽돌 갯수 (배열 값이 1이상인 것들의 갯수)
        queue<int> tmpQ = {};
        for (int h=H-1; h>=0; h--) {
            if (arr[h][w] != 0) {
                tmpQ.push(arr[h][w]);
            }

            if (h == 0) {
                for (int c=H-1; c>=0; c--) {
                    if (!tmpQ.empty()) {
                        arr[c][w] = tmpQ.front();
                        tmpQ.pop();
                    }
                    else {
                        arr[c][w] = 0;
                    }
                }
            }
        }  
    }
   

}
void copyArray(int arr[HMAX][WMAX], int target[HMAX][WMAX]) { // target을 arr로 덮어씌움
    for (int i=0; i<H; i++) {
        for (int j=0; j<W; j++) {
            target[i][j] = arr[i][j];
        }
    }
}
void bomb(int col) {
    for (int row=0; row<H; row++) {
        if (arr[row][col] != 0) {
            q.push(Node(row, col, arr[row][col] - 1));
            arr[row][col] = 0;
            break;
        }
    }

    while(!q.empty()) {
        int h = q.front().h;
        int w = q.front().w;
        int num = q.front().num;
        q.pop();

        for (int i=0; i<4; i++) {
            int tmpH = h;
            int tmpW = w;

            for (int j=1; j<=num; j++) {
                tmpH = h + dirH[i] * j;
                tmpW = w + dirW[i] * j;
                
                if (tmpH >= 0 && tmpH < HMAX && tmpW >= 0 && tmpW < WMAX) {
                    if (arr[tmpH][tmpW] != 0) {
                        q.push(Node(tmpH, tmpW, arr[tmpH][tmpW] - 1));
                        arr[tmpH][tmpW] = 0;
                    }
                }
            }
        }
    }
    sort(arr);
    
    return;
}


void dfs(int cnt) {
    if (cnt == N) { // 구슬 다 던졌으면 갯수 세기
        getAnswer();
        return;
    }

    int arrTmp[HMAX][WMAX];
    copyArray(arr, arrTmp);

    for (int col=0; col<W; col++) {
        bomb(col);
        dfs(cnt+1);
        copyArray(arrTmp, arr); // 다시 새로운 조합으로 bomb하려면 터트리기 전으로 돌아가야함
    }
}


int main(void) {

    cin >> N >> W >> H ; 

    answer = W*H;

    for (int i=0; i<H; i++) {
        for (int j=0; j<W; j++) {
            cin >> arr[i][j];
        }
    }
    
    dfs(0);
  
    cout << "answer:: " << answer << endl;

    return 0;
}

