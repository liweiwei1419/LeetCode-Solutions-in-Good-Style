#include <iostream>
#include <vector>

using namespace std;


class Solution {
private:

    // memo[i]：以 nums[i] 结尾的最长上升子序列的长度
    vector<int> memo;

    int getMaxLength(const vector<int> &nums, int index) {
        if (memo[index] != -1) {
            return memo[index];
        }

        int res = 1;
        for (int i = 0; i <= index - 1; i++) {
            if (nums[index] > nums[i]) {
                res = max(res, 1 + getMaxLength(nums, i));
            }
        }
        memo[index] = res;
        return res;
    }

public:
    int lengthOfLIS(vector<int> &nums) {
        // 特判
        int size = nums.size();
        if (size == 0) {
            return 0;
        }
        memo = vector<int>(size, -1);

        int res = 1;
        for (int i = 0; i < size; i++) {
            res = max(res, getMaxLength(nums, i));
        }
        return res;
    }
};