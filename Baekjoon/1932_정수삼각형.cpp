#include <iostream>

#define MAX 501

using namespace std;

int answer = 0;
int tri[MAX][MAX];
int trisum[MAX][MAX];


int main(void)
{
    int k;
    cin >> k;

    for (int i=1; i<=k; i++) {
        for (int j=1; j<=i; j++) {
            cin >> tri[i][j];
        }
    }

    trisum[1][1] = tri[1][1];

    for (int i=1; i<=k; i++) {
       for (int j=1; j<=i; j++) {
           if (trisum[i+1][j] < trisum[i][j]+tri[i+1][j]) { // 왼쪽
                trisum[i+1][j] = trisum[i][j]+tri[i+1][j];
           }
           if (trisum[i+1][j+1] < trisum[i][j]+tri[i+1][j+1]) { // 오른쪽
                trisum[i+1][j+1] = trisum[i][j]+tri[i+1][j+1];
           }
       }
    }

    for (int i=1; i<=k; i++) {
       for (int j=1; j<=i; j++) {
           if (answer < trisum[i][j]) { 
                answer = trisum[i][j];
           }
       }
    }

    cout << answer << endl;

    return 0;
}