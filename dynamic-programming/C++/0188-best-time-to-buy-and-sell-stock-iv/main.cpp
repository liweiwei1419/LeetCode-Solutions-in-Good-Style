#include <iostream>
#include <vector>


using namespace std;

class Solution {
public:

    typedef long long LL;
    LL INF = 1e12;

    int maxProfit(int k, vector<int> &prices) {

        // 调试一直不对

        int size = prices.size();
        if (size < 2 || k == 0) {
            return 0;
        }

        if (k > size / 2) {
            k = size / 2;
        }
        vector<vector<LL>> dp(k + 1, vector<LL>(2, -INF));
        dp[0][1] = 0;

        for (int i = 0; i < size; ++i) {
            for (int j = k; j >= 1; --j) {
                if (dp[j][0] != -INF) {
                    dp[j][1] = max(dp[j][1], dp[j][0] + prices[i]);
                }

                if (dp[i - 1][1] != -INF) {
                    dp[j][0] = max(dp[j][0], dp[j - 1][1] - prices[i]);
                }
            }
        }

        LL res = 0;
        for (int j = 1; j <= k; ++j) {
            res = max(res, dp[j][1]);
        }
        return res;
    }
};


int main() {
    int prices[] = {2, 4, 1};
    vector<int> vec1(prices, prices + sizeof(prices) / sizeof(int));
    int k = 2;
    int res = Solution().maxProfit(k, vec1);
    cout << res << endl;
}

