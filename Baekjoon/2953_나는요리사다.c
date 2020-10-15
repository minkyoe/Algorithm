#include <stdio.h>

int main(void) {

    int arr[5][4] = {0,};

    for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 4; j++)
        {
            scanf("%d", &arr[i][j]);
        }
        
    }

    int maxSum = 0;
    int idx = 0;

    for (int i = 0; i < 5; i++)
    {
        int sum = 0;
        for (int j = 0; j < 4; j++)
        {
            sum += arr[i][j];
        }

        if (maxSum < sum) {
            maxSum = sum;
            idx = i + 1;
        }
    }

    printf("%d %d", idx, maxSum);
    

    return 0;
}