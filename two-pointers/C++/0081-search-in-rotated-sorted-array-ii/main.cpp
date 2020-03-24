#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    bool search(vector<int> &nums, int target) {
        if (nums.empty()) {
            return false;
        }

        int left = 0;
        int right = nums.size() - 1;

        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[left]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[left]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                if (nums[left] == target) {
                    // 要排除掉左边界之前，先看一看左边界可以不可以排除
                    return true;
                }
                left = left + 1;
            }
        }
        return nums[left] == target;
    }
};