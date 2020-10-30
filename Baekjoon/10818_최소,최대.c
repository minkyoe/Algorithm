#include <stdio.h>

int main(void) {

    int N = 0;
    scanf("%d", &N);

    int arr[N];

    for (int i = 0; i < N; i++)
    {
        scanf("%d", &arr[i]);
    }

    int max = -1000000;
    int min = 1000000;
    for (int i = 0; i < N; i++)
    {
        int now = arr[i];
        max = max < now ? now : max;
        min = min > now ? now : min;
    }

    printf("%d %d", min, max);
    
    return 0;
}