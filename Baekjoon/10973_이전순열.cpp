#include <iostream>
#include <stdio.h>
#include <algorithm> // swap
#include <vector>

using namespace std;

/**
 * 
 * 자꾸 출력초과 .....ㅡㅡ............
 * 
 * ***/

vector<int> num;
int N;
void next_perm(vector<int> num) {
    bool flag = true;
    int idx1 = 0;
    for (int i=N-1; i>=0; i--) {
        if (num[i-1] <= num[i]) {
            continue;
        }
        else {
            if (i == 0) {
                flag = false;
            }
            else {
                idx1 = i-1;
                break;
            }
        }
    }

    int idx2 = 0;
    for (int i = N-1; i > idx1; i--) {
        if (num[idx1] <= num[i]) continue;
        else {
            idx2 = i;
            break;
        }
    }

    swap(num[idx1], num[idx2]);

    int behind = N-1;
    int front = idx1+1;

    while (front < behind) {
        swap(num[behind], num[front]);
        front++;
        behind--;
    }

    if (!flag) {
        printf("-1");
    } 
    else {
        for (int n=0; n<N; n++) {
            if (n == N-1) {
                printf("%d", num[n]);
            }
            else {
                printf("%d ", num[n]);
            }
        }
    }
} 

int main(void){
    
    scanf("%d", &N);
    num = vector<int>(N,0);

    for (int i=0; i<N; i++) {
        scanf("%d", &num[i]);
    }

    next_perm(num);
    
    return 0;
}