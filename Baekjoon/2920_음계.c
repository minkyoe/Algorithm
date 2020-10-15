#include <stdio.h>

int main(void) {
    int arr[8];

    for (int i = 0; i < 8; i++)
    {
        scanf("%d", &arr[i]);
    }

    int isAscend = 0; // 0: descend , 1: ascend , 2: mixed
    if (arr[0] < arr[1]) isAscend = 1;

    for (int i = 1; i < 7; i++)
    {
        if (isAscend == 0) {
            if (arr[i] < arr[i+1]) {
                isAscend = 2;
                break;
            }
        }
        else {
            if (arr[i] > arr[i+1]) {
                isAscend = 2;
                break;
            }
        }
    }

    if (isAscend == 0) printf("descending");
    else if (isAscend == 1) printf("ascending");
    else printf("mixed");
    

    return 0;
}