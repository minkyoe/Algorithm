#include <stdio.h>
int main(void) {
    int h = 0; int m = 0;

    scanf("%d %d", &h, &m);

    if (m < 45) {
        m = 60+m - 45;

        if (h == 0) {
            h = 23;
        } else {
            h -= 1;
        }
    } else {
        m -= 45;
    }

    printf("%d %d", h, m);

    return 0;
}