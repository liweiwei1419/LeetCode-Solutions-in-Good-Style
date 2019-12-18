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
        // 遍历一遍找到最大元素
        int n = *max_element(begin(A), end(A));
        // 因为数组要包括最后一个元素，所以 + 1
        UnionFind unionFind(n + 1);

        // 对于每一个数，遍历它所有的公因子
        // 如果能够被整除，把这两个因子做一个合并
        // 这个时候，代表元就是那些公因子
        for (int a: A) {
            for (int k = 2; k <= sqrt(a); k++) {
                if (a % k == 0) {
                    unionFind.merge(a, k);
                    unionFind.merge(a, a / k);
                }
            }
        }

        // 写成这样比较难理解
        // 就是找 叶子 最多的那个结点，即 包含子结点最多的那个 root
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

