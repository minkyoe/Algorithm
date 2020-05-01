#include <string>
#include <vector>
#include <iostream>
#define N 20
#define M 20

using namespace std;

int keyArr[M][M];
int keySize, lockSize, boardSize;

void keyArrCopy(int keyArr[M][M], int target[M][M]){
     for (int i=0; i<keySize; i++) {
        for (int j=0; j<keySize; j++) {
            target[i][j] = keyArr[i][j];
        }
    }
}

// 시계방향 90도 회전 (반시계는 시계방향회전*3)
void rotate(int arr[M][M]) {
    int copyArr[M][M];
    keyArrCopy(arr, copyArr);

    for (int i=0; i<keySize; i++) {
        for (int j=0; j<keySize; j++) {
            arr[i][j] = copyArr[keySize-1-j][i];
        }
    }
}

bool check(int h, int w, vector<vector<int>> board) {
    // key값 더하기
    for (int i=h; i<h+keySize; i++) {
        for (int j=w; j<w+keySize; j++) {
            board[i][j] += keyArr[i-h][j-w];
        }
    }

    // 모든 값이 0이 아닌지 검사
    for (int i=keySize-1; i<=boardSize-keySize; i++) {
        for (int j=keySize-1; j<=boardSize-keySize; j++) {
            if (board[i][j] != 1) return false;
        }
    }

    return true;


}

bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
    bool answer = false;

    keySize = key.size();
    lockSize = lock.size();
    boardSize = lockSize + (keySize - 1) * 2;


    for (int i=0; i<key.size(); i++) {
        for (int j=0; j<key[i].size(); j++) {
            keyArr[i][j] = key[i][j];
        }
    }

    // board 생성 및 초기화
    vector<vector<int>> boardArr(boardSize, vector<int>(boardSize, 0)); // 가로 boardSize줄 인데 각 줄은 boardSize만큼 0으로 초기화 됨

    // board에 lock고정
    for (int i=keySize-1; i<=boardSize-keySize; i++) {
        for (int j=keySize-1; j<=boardSize-keySize; j++) {
            boardArr[i][j] = lock[i-keySize+1][j-keySize+1];
        }
    }

    // board 0,0 부분부터 size-1, size-1까지 key의 시작부분으로 맞춰서 체크
    for (int i=0; i<=boardSize-keySize; i++) {
        for (int j=0; j<=boardSize-keySize; j++) {
            for (int k=0; k<=4; k++) {
                rotate(keyArr);
                if (check(i, j, boardArr)) {
                    answer = true;
                    return answer;
                }
            }
           
        }
    }


    return answer;
}

int main(void) {
    // solution({{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}});
    cout << "answer:: " << solution({{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}) << endl;
}