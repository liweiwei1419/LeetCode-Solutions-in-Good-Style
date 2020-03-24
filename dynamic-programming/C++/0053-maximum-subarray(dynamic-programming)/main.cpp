#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int maxSubArray(vector<int> &nums) {
        int res = INT_MIN;
        int pre = 0;
        for (int i = 0; i < nums.size(); ++i) {
            int cur = max(pre, 0) + nums[i];
            res = max(res, cur);
            pre = cur;
        }
        return res;
    }
};