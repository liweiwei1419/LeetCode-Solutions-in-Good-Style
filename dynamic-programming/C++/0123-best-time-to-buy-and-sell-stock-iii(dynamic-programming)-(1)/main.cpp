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

        int hold1 = INT_MIN;
        int cash1 = 0;
        int hold2 = INT_MIN;
        int cash2 = 0;
        for (int price : prices) {
            cash2 = max(cash2, hold2 + price);
            hold2 = max(hold2, cash1 - price);
            cash1 = max(cash1, hold1 + price);
            hold1 = max(hold1, -price);
        }
        return cash2;
    }
};

