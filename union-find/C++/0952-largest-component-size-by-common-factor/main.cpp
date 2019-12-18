#include <iostream>
#include <vector>
#include <math.h>
#include <unordered_map>

using namespace std;

class UnionFind {
private:
    vector<int> parent;
public:
    UnionFind(int n) : parent(n) {
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    void merge(int x, int y) {
        parent[find(x)] = parent[find(y)];
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
};

class Solution {
public:
    int largestComponentSize(vector<int> &A) {
        int n = *max_element(begin(A), end(A));
        UnionFind unionFind(n + 1);

        for (int a: A) {
            for (int k = 2; k <= sqrt(a); k++) {
                if (a % k == 0) {
                    unionFind.merge(a, k);
                    unionFind.merge(a, a / k);
                }
            }
        }
        unordered_map<int, int> hashMap;
        int res = 1;
        for (int a:A) {
            res = max(res, ++hashMap[unionFind.find(a)]);
        }
        return res;
    }
};

int main() {
    vector<int> A = {4, 6, 15, 35};

    Solution solution = Solution();
    int res = solution.largestComponentSize(A);
    cout << res << endl;
    return 0;
}

