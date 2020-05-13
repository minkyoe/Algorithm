#include <iostream>
#include <vector>

using namespace std;

vector<pair<int, int>> wh;
vector<int> answers;

int main(void)
{

    int k;
    cin >> k;

    for (int i=0; i<k; i++) {
        int weight;
        int height;

        cin >> weight >> height;

        wh.push_back(make_pair(weight, height));
    }

    for(int j=0; j<k; j++) {
        int count = 0;
        for (int n=0; n<k; n++) {
            if (n == j) continue;
            if (wh[n].first > wh[j].first && wh[n].second > wh[j].second) count++; 
        }
        answers.push_back(count+1);
    }

    for (int a=0; a<answers.size(); a++) {
        cout << answers[a] << " ";
    }



    return 0;
}