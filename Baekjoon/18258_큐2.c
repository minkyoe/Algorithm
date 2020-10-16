#include <stdio.h>
#include <stdbool.h>
#include <string.h>

#define MAX 2000001

int main(void){
    int N = 0; // 명령의 수
    int q[MAX];
    int front = 0;
    int rear = -1;

    char command[20] = {0,};
    int num = 0;

    scanf("%d",&N);
    for (int i = 0; i < N; i++)
    {
        scanf("%s",command);

        if (strcmp(command,"push") == 0) {
            scanf("%d",&num);
            if(rear == MAX - 1) continue;
            q[++rear] = num;
        }
        else if (strcmp(command,"pop") == 0) {
            if(front > rear) printf("-1\n");
            else printf("%d\n", q[front++]);
        }
        else if (strcmp(command,"size") == 0) {
            printf("%d\n", rear-front+1);
        }
        else if (strcmp(command,"empty") == 0) {
            if (front > rear) printf("1\n");
            else printf("0\n");
        }
        else if (strcmp(command,"front") == 0) {
            if (front > rear) printf("-1\n");
            else printf("%d\n", q[front]);
        }
        else if (strcmp(command,"back") == 0) {
            if (front > rear) printf("-1\n");
            else printf("%d\n", q[rear]);
        }
        
    }
  
    return 0;

}