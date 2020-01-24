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

        // [0, left] 区间里进行一次买卖的最大收益
        vector<int> left(size, 0);
        int minVal = prices[0];
        for (int i = 1; i < size - 1; ++i) {
            left[i] = max(left[i - 1], prices[i] - minVal);
            minVal = min(minVal, prices[i]);
        }

        // [right, len - 1] 区间里进行一次买卖的最大收益
        vector<int> right(size, 0);
        int maxVal = prices[size - 1];
        for (int i = size - 2; i >= 0; --i) {
            right[i] = max(right[i + 1], maxVal - prices[i]);
            maxVal = max(maxVal, prices[i]);
        }

        // 枚举间隙
        // [0, 1[, 2, 3,] 4, 5]
        // 这里有一个坑，有可能是只交易一次的场景
        int res = max(left[size - 1], right[0]);
        for (int i = 1; i < size - 2; ++i) {
            res = max(res, left[i] + right[i + 1]);
        }
        return res;
    }
};