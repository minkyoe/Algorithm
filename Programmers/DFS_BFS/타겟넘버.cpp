#include <vector>
#include <iostream>

using namespace std;

int answer = 0;

void dfs(vector<int> numbers, int target, int sum, int index)
{

    if (index == numbers.size())
    {
        if (sum == target)
        {
            answer++;
        }
        return; // 배열 끝까지 돌았으면 무조건 return
    }

    dfs(numbers, target, sum + numbers[index], index + 1);
    dfs(numbers, target, sum - numbers[index], index + 1);
}

int solution(vector<int> numbers, int target)
{
    dfs(numbers, target, 0, 0);

    return answer;
}

int main(void)
{

    vector<int> numbers = {1, 1, 1, 1, 1};
    int real_answer = solution(numbers, 3);

    return 0;
}