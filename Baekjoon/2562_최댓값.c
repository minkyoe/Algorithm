#include <stdio.h>

int main(void){

    int arr[9];

    for (int i = 0; i < 9; i++)
    {
        scanf("%d", &arr[i]);
    }

    int idx = 0;
    int max = 0;
    for (int i = 0; i < 9; i++)
    {
        int now = arr[i];
        if (now > max) {
            max = now;
            idx = i+1;
        }
    }
    
    printf("%d\n", max);
    printf("%d\n", idx);

    return 0;
}