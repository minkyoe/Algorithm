#include <stdio.h>

int main(void) {
    int tc = 0;
    scanf("%d", &tc);

    for (int i = 0; i < tc; i++)
    {
        char str[81];
        scanf("%s", str);

        int idx = 0;
        int score = 1;
        int sum = 0;
        while (str[idx] != '\0')
        {
            if (str[idx] == 'O') {
                sum += score;
                score++;
            }
            else {
                score = 1;
            }
            idx++;
        }
        printf("%d\n", sum);
        
    }
    

    return 0;
}