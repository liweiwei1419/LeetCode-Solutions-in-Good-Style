#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    int maxProfit(vector<int> &prices) {
        int size = prices.size();
        if (size <= 1) {
            return 0;
        }

        // 差分数组
        vector<int> diff(size - 1, 0);
        for (int i = 0; i < size - 1; ++i) {
            diff[i] = prices[i + 1] - prices[i];
        }

        // 下面转化成求解差分数组的最大子段和
        vector<int> dp(size - 1, 0);
        dp[0] = max(0, diff[0]);
        int res = dp[0];

        for (int i = 1; i < size - 1; ++i) {
            // 最大子段和的状态转移方程
            dp[i] = max(0, dp[i - 1]) + diff[i];
            res = max(res, dp[i]);
        }
        return res;
    }
};

