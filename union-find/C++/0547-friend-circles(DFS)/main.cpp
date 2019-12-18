#include <iostream>
#include <vector>

using namespace std;

class Solution {
private:
    /**
     * 记录是否被访问过
     */
    vector<int> visited;

    /**
     * 一共 N 名学生
     */
    int N;

    void dfs(int u, vector<vector<int>> &M) {
        if (visited[u]) {
            return;
        }

        visited[u] = 1;

        for (int i = 0; i < N; ++i) {
            // 如果是朋友关系，就继续遍历下去，这是深度优先遍历
            if (M[u][i]) {
                dfs(i, M);
            }
        }
    }

public:
    int findCircleNum(vector<vector<int>> &M) {
        N = M.size();
        if (N == 0) {
            return 0;
        }

        // 连通分量
        int res = 0;
        visited.assign(N, 0);

        for (int i = 0; i < N; ++i) {
            if (visited[i]) {
                continue;
            }

            dfs(i, M);
            res++;
        }
        return res;
    }
};