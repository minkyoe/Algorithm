#include <string>
#include <vector>
#include <cstdlib>
#include <iostream>

using namespace std;

int comp(string a, string b){

    int length_a = a.length();
    int length_b = b.length();
    int real_length = 0;

    if(length_a > length_b){
        b.append("0",length_a-length_b);
        real_length = length_a;
    } 
    else if(length_a < length_b){
        a.append("0",length_b-length_a);
        real_length = length_b;
    } 
    else if(length_a == length_b) real_length = length_a;


    for(int k=0; k<real_length; k++){
        string s1(1,a.at(k));
        string s2(1,b.at(k));
        int cmp1 = stoi(s1);
        cout<<"a: "<<a<<" "<<endl;
        cout<<"cmp1: "<<cmp1<<" "<<endl;
        int cmp2 = stoi(s2);
        cout<<"b: "<<b<<" "<<endl;
        cout<<"cmp2: "<<cmp2<<" "<<endl;

        if(cmp1 > cmp2){
            return 0; // cmp1이 cmp2보다 앞자리 수들이 클 경우
        }else if(cmp1 < cmp2){
            return 1; // cmp2이 cmp1보다 앞자리 수들이 클 경우
        }else if(cmp1 == cmp2){
            if(k==real_length-1){
                
            } return 0; // cmp1과 cmp2가 아예 같을 경우
            else continue;
        }
    }
}

/*
vector<string> append_string(string a, string b){
    int length_a = a.length();
    int length_b = b.length();
    int real_length = 0;

    if(length_a > length_b){
        b.append("0",length_b,length_a-1);
        real_length = length_a;
    } 
    else if(length_a < length_b){
        a.append("0",length_a,length_b-1);
        real_length = length_b;
    } 
    else if(length_a == length_b) real_length = length_a;
    
    vector<string> temp = {};
    temp[0] = a;
    temp[1] = b;
    
    return temp;

}

int comp(string a, string b){
    
    vector<string> temp = append_string(a,b);
    string aa = temp[0];
    string bb = temp[1];
    
    if(aa == bb) return 0;

    string ab = aa + bb;
    string ba = bb + aa;

    if(ab > ba) return 0;
    else return 1;
}
*/
void swap(int idx1, int idx2, vector<int> numbers){
    int temp;
    temp = numbers[idx1];
    numbers[idx1] = numbers[idx2];
    numbers[idx2] = temp;
}

string solution(vector<int> numbers) {
    string answer = "";
    
    for(int i=0; i<numbers.size(); i++){
        for(int j=i; j<numbers.size(); j++){
            if(j<numbers.size()-1){
                int flag;
                flag=comp(to_string(numbers[i]),to_string(numbers[j+1]));
                cout<<"flag: "<<flag<<" "<<endl;
                if(flag == 0) continue;
                else if(flag==1){
                    int temp;
                    temp = numbers[i];
                    numbers[i] = numbers[j+1];
                    numbers[j+1] = temp;
                } 
            }else continue;
        }
    }

    for(int n=0; n<numbers.size(); n++){
        string s = to_string(numbers[n]);
        answer += s;
    }
    
    return answer;
}

int main(void){
    vector<int> numbers = {6,10,2};
    string answer=solution(numbers);
    cout<<answer;


    return 0;
}