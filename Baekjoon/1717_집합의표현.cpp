#include <iostream>
#include <vector>
using namespace std;

/**
 * 입출력 시간초과
 * cin.tie(NULL);
 * std::ios::sync_with_stdio(false);
 * endl ==> "\n"
 **/

int n, m;
vector<int> root;
vector<int> input (3);

int getRoot(int x) {
    if (x == root[x])
        return x;
    else
        return root[x] = getRoot(root[x]);
}

void merge(int x, int y) {
    x = getRoot(x);
    y = getRoot(y);

    if (x == y) return;
    root[y] = x;
}

int main(void) {
    cin.tie(NULL);
    std::ios::sync_with_stdio(false);

    cin >> n >> m;

    root = vector<int> (n+1);
    for (int i=0; i<root.size(); i++) {
        root[i] = i;
    }

    for (int j=0; j<m; j++) {
        cin >> input[0] >> input[1] >> input[2];

        if (input[0] == 0) {
            merge(input[1], input[2]);
        }
        else {
            int x = getRoot(input[1]);
            int y = getRoot(input[2]);

            if (x == y) {
                cout << "YES" << "\n";
            }
            else {
                cout << "NO" << "\n";
            }
        }
    }
}