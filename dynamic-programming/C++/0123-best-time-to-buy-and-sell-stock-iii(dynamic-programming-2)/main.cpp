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

        // dp[j] ，i 表示 [0, i] 区间里，状态为 j 的最大收益
        // j = 0：什么都不操作
        // j = 1：第 1 次买入一支股票
        // j = 2：第 1 次卖出一支股票
        // j = 3：第 2 次买入一支股票
        // j = 4：第 2 次卖出一支股票

        vector<int> dp(5);
        dp[0] = 0;
        dp[1] = -prices[0];
        dp[2] = INT16_MIN;
        dp[3] = INT16_MIN;
        dp[4] = INT16_MIN;

        for (int i = 1; i < size; i++) {
            if (dp[3] != INT16_MIN) {
                dp[4] = max(dp[4], dp[3] + prices[i]);
            }
            if (dp[2] != INT16_MIN) {
                dp[3] = max(dp[3], dp[2] - prices[i]);
            }
            dp[2] = max(dp[2], dp[1] + prices[i]);
            dp[1] = max(dp[1], -prices[i]);
        }
        return max(0, max(dp[2], dp[4]));
    }
};
