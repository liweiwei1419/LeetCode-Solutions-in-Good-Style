#include <iostream>
#include <vector>


using namespace std;


class Solution {
public:
    int maxSubArray(vector<int> &nums) {
        int size = nums.size();
        int res = INT32_MIN;
        for (int i = 0; i < size; ++i) {
            int sum = 0;
            for (int j = i; j < size; ++j) {
                sum += nums[j];
                res = max(res, sum);
            }

        }
        return res;
    }
};