#include <stdio.h>

int main (void) {

    int n = 0;
    scanf("%d", &n);
    int arr[n];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }

    // 최대공약수 구하기
    int gcd = 0;
    for (int i = 0; i < n-1; i++)
    {
        int a = arr[i];
        if (i == 1) a = gcd;
        int b = arr[i+1];

        while (a != 0) {
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }

            int temp = b%a;
            b = a;
            a = temp;
        }
        gcd = b;
    }
    
    // 약수 구하기
    for (int i = 1; i <= gcd; i++)
    {
        if (gcd % i == 0) {
            printf("%d\n",i);
        }
    }
    
    
    return 0;
}