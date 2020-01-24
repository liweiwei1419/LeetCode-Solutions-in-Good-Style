#include <iostream>
#include <vector>

using namespace std;

class Solution {

private:
    vector<int> parent;
    /**
     * 关于每个代表元而言
     */
    vector<int> rank;

    void init(int n) {
        for (int i = 0; i < n; ++i) {
            parent.push_back(i);
        }

        rank.assign(n, 0);
    }

    /**
     * 使用了路径压缩的 find 操作
     * @param x
     * @return
     */
    int find(int x) {
        if (parent[x] == x) {
            // 如果自己的父结点是自己，说明，自己是代表元
            return x;
        }
        // 从右边向左边读这个过程
        // 理解"路径压缩"这个操作
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
            return 0;
        }

        if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
        } else if (rank[root1] == rank[root2]) {
            parent[root1] = root2;
            rank[root2]++;
        } else {
            parent[root2] = root1;
        }
        return 1;
    }

public:
    int findCircleNum(vector<vector<int>> &M) {
        int N = M.size();
        // 初始化并查集
        init(N);

        int res = N;
        // 注意：只需要对上三角形进行初始化
        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                if (M[i][j]) {
                    res -= merge(i, j);
                }
            }
        }
        return res;
    }
};

