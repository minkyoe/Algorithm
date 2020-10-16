#include <stdio.h>
#include <string.h>

int main (void){

    char s[1000002];
    int cnt = 0;
    gets(s);
    int len = strlen(s);
    for (int i = 0; i < len; i++) 
    {
        if (s[i] != ' ') {
            cnt++;
            i++;
            while (i < len && s[i] != ' ')
            {
                i++;
                continue;
            }
        }

        if (s[i] == '\n') break;
    }

    printf("%d",cnt);
    return 0;
}