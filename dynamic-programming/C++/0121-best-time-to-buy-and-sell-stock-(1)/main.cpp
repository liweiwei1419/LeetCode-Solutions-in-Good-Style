#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int maxProfit(vector<int> &prices) {
        // 特判
        int size = prices.size();
        if (size == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int res = 0;
        for (int i = 1; i < size; i++) {
            res = max(res, prices[i] - minPrice);
            minPrice = min(minPrice, prices[i]);
        }
        return res;
    }
};


