#include <stdio.h>
#include <string.h>

int main(void) {
    char str[101];
    scanf("%s", str);
    int idx = 0;
    int size = 0;
    while (str[idx] != '\0')
    {
        size++;
        idx++;
    }

    int ans[26] = {-1,};
    memset(ans, -1, sizeof(ans));
    for (int i = 0; i < size; i++)
    {
        char tmp = str[i];
        if (ans[tmp-97] != -1) continue;
        ans[tmp-97] = i;
    }
    

    for (int i = 0; i < 26; i++)
    {
        printf("%d ", ans[i]);
    }
    
    return 0;
}