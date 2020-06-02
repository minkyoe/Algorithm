#include <iostream>
#include <string>
#include <map>

// 나중에 또 복습해보면 좋을듯!

using namespace std;

int tc, F;
map<string, string> root;
map<string, int> setSize;

string getRoot(string x) {
    if (x == root[x]) return x;
    else return root[x] = getRoot(root[x]);
}

void merge(string x, string y) {
    x = getRoot(x);
    y = getRoot(y);

    if (x == y) return;

    if (setSize[x] < setSize[y]) swap(x, y);
    root[y] = x;
    setSize[x] += setSize[y];
    setSize[y] = 0;
}

int main(void) {
    cin.tie(NULL);
    std::ios::sync_with_stdio(false);

    cin >> tc;

    while (tc--) {
        cin >> F;
        string str1, str2;
        root.clear();
        setSize.clear();

        for(int i=0; i<F; i++) {
            cin >> str1 >> str2;

            if(root.count(str1) == 0) {
                root[str1] = str1;
                setSize[str1] = 1;
            }
            if(root.count(str2) == 0) {
                root[str2] = str2;
                setSize[str2] = 1;
            } 

            string root1 = getRoot(str1);
            string root2 = getRoot(str2);

            if (root1 == root2) cout << max(setSize[root1], setSize[root2]) << "\n";
            else {
                merge(root1, root2);
                cout << max(setSize[root1], setSize[root2]) << "\n";
            }

        }
    }

}
