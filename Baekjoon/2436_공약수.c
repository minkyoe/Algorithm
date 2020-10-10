#include <stdio.h>
#include <math.h>

int isSeoroso(int a, int b) {
    while (a != 0) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        int temp = b % a;
        b = a;
        a = temp;
    }

    if (b == 1) return 1;
    else return 0;
}
int main(void) {
    int gcd = 0;
    int lcm = 0;

    scanf("%d %d", &gcd, &lcm);

    int num = lcm / gcd;
    int hap = 2 * 100000000;

    // 두 숫자
    int a = 0;
    int b = 0;
    int ansA = 0;
    int ansB = 0;
    for (int i = 1; i * i <= num; i++)
    {
        if (num % i == 0 && isSeoroso(i, num/i) == 1) {
            a = i * gcd;
            b = num / i * gcd;

            if (a+b < hap) {
                hap = a+b;
                ansA = a;
                ansB = b;
            }
        }
    }
    
    printf("%d %d", ansA, ansB);

    return 0;
}