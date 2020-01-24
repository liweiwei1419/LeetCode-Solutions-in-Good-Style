#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int maxProfit(vector<int> &prices) {
        size_t size = prices.size();
        if (size < 2) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < size; ++i) {
            res += prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0;
        }
        return res;
    }
};