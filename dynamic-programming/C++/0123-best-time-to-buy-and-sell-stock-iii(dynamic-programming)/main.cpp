#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int maxProfit(vector<int> &prices) {
        // 特判
        int size = prices.size();
        if (size < 2) {
            return 0;
        }

        // dp[i][j] ，i 表示 [0, i] 区间里，状态为 j 的最大收益
        // j = 0：什么都不操作
        // j = 1：第 1 次买入一支股票
        // j = 2：第 1 次卖出一支股票
        // j = 3：第 2 次买入一支股票
        // j = 4：第 2 次卖出一支股票


        vector<vector<int>> dp(size, vector<int>(5));
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        // 比较奇怪的赋初值方法
        for (int i = 0; i < size; ++i) {
            dp[i][2] = INT16_MIN;
            dp[i][3] = INT16_MIN;
            dp[i][4] = INT16_MIN;
        }

        for (int i = 1; i < size; i++) {
            dp[i][0] = 0;
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = max(dp[i - 1][2], dp[i - 1][1] + prices[i]);

            if (dp[i - 1][2] != INT16_MIN) {
                dp[i][3] = max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            }

            if (dp[i - 1][3] != INT16_MIN) {
                dp[i][4] = max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
            }
        }
        return max(0, max(dp[size - 1][2], dp[size - 1][4]));
    }
};