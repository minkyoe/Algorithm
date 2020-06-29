#include <iostream>

using namespace std;

int num;

int main(void) {

    ios_base :: sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL);

    cin >> num;

    int cnt = 0;

	while (1) {
		if (num % 5 == 0) {
			cout << num / 5 + cnt << "\n";
			break;
		}
		else if (num <= 0) {
            cout << "-1" << "\n";
			break;
		}
		num -= 3;
		cnt++;
	}

    return 0;
}