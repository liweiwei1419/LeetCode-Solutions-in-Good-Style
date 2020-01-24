#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>> &obstacleGrid) {
        int m = obstacleGrid.size();
        if (m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].size();
        vector<long> dp(n + 1, 0);

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // 注意：这里是索引为 1 的位置
        dp[1] = 1;
        // 下面这两行赋值比较关键
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j + 1] = 0;
                } else {
                    dp[j + 1] += dp[j];
                }
            }
        }
        return dp[n];
    }
};