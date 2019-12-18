#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
private:
    unordered_map<int, int> parent;
    unordered_map<int, int> sz;

    /**
     * 采用了路径压缩
     * @param x
     * @return
     */
    int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }


    /**
     * 按秩合并
     * @param x
     * @param y
     * @return
     */
    int merge(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        if (root1 == root2) {
            return sz[root1];
        }
        parent[root2] = root1;
        sz[root1] += sz[root2];
        return sz[root1];
    }


public:
    int longestConsecutive(vector<int> &nums) {
        int size = nums.size();
        if (size == 0) {
            return 0;
        }

        for (int num:nums) {
            parent[num] = num;
            sz[num] = 1;
        }

        int res = 1;
        for (int num:nums) {

            if (num != INT_MIN && parent.count(num - 1)) {
                res = max(res, merge(num - 1, num));
            }

            if (num != INT_MAX && parent.count(num + 1)) {
                res = max(res, merge(num, num + 1));
            }
        }
        return res;
    }
};


