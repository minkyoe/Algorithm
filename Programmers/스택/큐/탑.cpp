#include <string>
#include <vector>
#include <iostream>
#include <stack>
/**
 * Line 2019 상반기 주3일 인턴 코딩테스트 4번문제와 비슷!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * ***/
using namespace std;

vector<int> solution(vector<int> heights) {
    vector<int> answer;
    stack<int> st;

    for (int i=heights.size()-1; i>=0; i--){
        if (i==0) st.push(0);
        else {
            for (int j=i-1; j>=0; j--) {
                if (heights[i] < heights[j]) { 
                    st.push(j+1);
                    cout << "top:: " << st.top() << endl;
                    break;
                } else {
                    if (j==0) st.push(0);
                    else continue;
                }
            }
        }
    }

    for (int i=0; i<heights.size(); i++) {
        answer.push_back(st.top());
        st.pop();
    }
    return answer;
}

int main(void)
{

    vector<int> numbers = {6,9,5,7,4};
    vector<int> answer = solution(numbers);

    for (int i=0; i<answer.size(); i++) {
        cout << answer[i] << " ";
    }

    return 0;
}