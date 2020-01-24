#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int minimumTotal(vector<vector<int>> &triangle) {
        int size = triangle.size();
        if (size == 0) {
            return 0;
        }
        vector<int> dp(size, 0);
        // 最后一层有 size 个元素
        for (int i = 0; i < size; ++i) {
            dp[i] = triangle[size - 1][i];
        }
        for (int i = size - 2; i >= 0; --i) {
            for (int j = 0; j <= i; ++j) {
                dp[j] = min(dp[j], dp[j + 1]) + triangle[i][j];
            }
        }
        return dp[0];
    }
};