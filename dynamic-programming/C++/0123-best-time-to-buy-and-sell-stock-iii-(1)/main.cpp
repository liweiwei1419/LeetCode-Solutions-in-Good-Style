#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int maxProfit(vector<int> &prices) {
        unsigned long size = prices.size();
        if (size == 0) {
            return 0;
        }

        vector<int> dp1(size, 0);
        int minPrice = prices[0];
        for (int i = 1; i < size; i++) {
            dp1[i] = max(dp1[i - 1], prices[i] - minPrice);
            minPrice = min(minPrice, prices[i]);
        }

        vector<int> dp2(size, 0);
        int maxPrice = prices.back();
        for (int i = size - 2; i >= 0; i--) {
            dp2[i] = max(dp2[i + 1], maxPrice - prices[i]);
            maxPrice = max(maxPrice, prices[i]);
        }

        int res = dp2[0];
        for (int i = 0; i < size - 1; i++)
            res = max(res, dp1[i] + dp2[i + 1]);
        res = max(res, dp1.back());
        return res;
    }
};