#include <stack>
#include <iostream>
#include <string>
#include <stdio.h>
using namespace std;

int main(void)
{
    int N = 0; // 피연산자 개수
    cin >> N;

    string s = ""; // 후위 표기식
    cin >> s;

    double num[N];
    for (int i = 0; i < N; i++)
    {
        cin >> num[i];
    }

    stack<double> st;
    for (char c : s)
    {
        if (c != '+' && c != '-' && c != '*' && c != '/')
        { // 피연산자라면 스택에 푸쉬
            st.push(num[c - 'A']);
        }
        else
        { // 연산자라면
            double num2 = st.top();
            st.pop();
            double num1 = st.top();
            st.pop();

           double result = 0; 
            switch (c)
            {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1/num2;
                break;
            }

            st.push(result);
        }
    }
    
    printf("%.2f", st.top());


    return 0;
}