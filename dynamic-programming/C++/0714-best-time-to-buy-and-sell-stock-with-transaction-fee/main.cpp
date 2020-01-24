#include <iostream>
#include <vector>


using namespace std;


class Solution {
public:
    int maxProfit(vector<int> &prices, int fee) {
        int size = prices.size();
        if (size < 2) {
            return 0;
        }

        // 差分数组
        vector<int> diff(size - 1, 0);
        for (int i = 0; i < size - 1; ++i) {
            diff[i] = (prices[i + 1] - prices[i]);
        }
        vector<int> dp(2, 0);
        dp[0] = 0;
        dp[1] = diff[0] - fee;
        for (int i = 1; i < size - 1; ++i) {
            dp[0] = max(dp[0], dp[1]);
            dp[1] = max(dp[1] + diff[i], dp[0] + diff[i] - fee);
        }
        return max(dp[0], dp[1]);
    }
};

