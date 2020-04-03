#include <string>
#include <vector>
#include <algorithm> // sort함수

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    vector<vector<int>>::iterator it = commands.begin();
    
    for(int n=0; it!=commands.end(); ++it){
        int i = (*it)[0];
        int j = (*it)[1];
        int k = (*it)[2];
        
        vector<int> array_cut;
        for(int m=i-1; m<j; m++){
            array_cut.push_back(array[m]);
        }
        
        sort(array_cut.begin(),array_cut.end());
        answer.push_back(array_cut[k-1]);
        
    }
    return answer;
}

int main() {
    
    return 0;
}