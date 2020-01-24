#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int firstMissingPositive(vector<int> &nums) {
        size_t length = nums.size();
        if (length == 0) {
            return 1;

        }

        // 小心 1, 1]这种例子会造成死循环，要特殊处理。（nums[i] != nums[nums[i]-1）
        for (int i = 0; i < length; i++)
            while (nums[i] >= 1 && nums[i] <= length && i != nums[i] - 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums[i], nums[nums[i] - 1]);
            }

        for (int i = 0; i < length; i++)
            if (i != nums[i] - 1) {
                return i + 1;
            }
        return length + 1;
    }
};
