#include <iostream>
#include <string>

using namespace std;

int main(void) {

    string tmp;
    cin >> tmp;

    for (int i=0; i<tmp.size(); i++) {
        if (tmp[i] != tmp[tmp.size()-i-1]) {
            cout << "0" << endl;
            return 0;
        }
    }

    cout << "1" << endl;
    return 0;
}

