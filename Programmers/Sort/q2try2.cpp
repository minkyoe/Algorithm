#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

bool comp(string a, string b){
 
    string ab = a + b;
    string ba = b + a;

    if(ab > ba) return true;
    else return false;
}

string solution(vector<int> numbers) {
    string answer = "";
    vector<string> s_numbers;
    int zero_cnt = 0;
    
    for(int i=0;i<numbers.size();i++){
        int num = numbers[i];
        if(num==0) ++zero_cnt;
        s_numbers.push_back(to_string(num));
    }
    sort(s_numbers.begin(),s_numbers.end(),comp);

    
    for(int k=0;k<s_numbers.size();k++){
        answer.append(s_numbers[k]);
    }
    
    if(answer[0]=='0') answer = "0";

    return answer;
}

int main(void){
    vector<int> numbers = {6,10,2};
    string answer=solution(numbers);
    cout<<answer;


    return 0;
}