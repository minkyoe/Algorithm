#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(int brown, int red)
{
    vector<int> answer;
    int sum = brown + red;
    int width = 0;
    int height = 0;

    for (int i = 2; i <= sum; i++)
    {
        if (sum % i == 0)
        {
            int temp = sum / i;
            if (temp >= i && (temp - 2) * (i - 2) == red)
            {

                width = temp;
                height = i;
                break;
            }
            else
                continue;
        }
    }

    answer.push_back(width);
    answer.push_back(height);

    return answer;
}

int main(void)
{
    vector<int> answer = solution(8, 1);
    for (int i = 0; i < answer.size(); i++)
    {
        cout << answer[i] << " ";
    }
    return 0;
}