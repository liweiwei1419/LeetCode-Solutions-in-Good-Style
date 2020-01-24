#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int searchInsert(vector<int> &nums, int target) {
        int size = nums.size();
        if (size == 0) {
            return 0;
        }

        int left = 0;
        int right = size;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 下一轮搜索区间是 [mid + 1, right]
                left = mid + 1;
            } else if (nums[mid] == target) {
                // 根据本题特殊性，看到等于 target 的元素，返回任意一个即可
                return mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
};