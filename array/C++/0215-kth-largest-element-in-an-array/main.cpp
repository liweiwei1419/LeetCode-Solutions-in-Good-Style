#include <iostream>
#include <vector>


using namespace std;

class Solution {
public:
    int findKthLargest(vector<int> &nums, int k) {
        int l = 0, r = nums.size() - 1;
        k = nums.size() - k;
        while (l <= r) {
            int p = partition(nums, l, r);
            if (k < p) {
                r = p - 1;
            } else if (k > p) {
                l = p + 1;
            } else {
                return nums[p];
            }
        }
        return nums[0];
    }

    int partition(vector<int> &nums, int l, int r) {
        // 随机在 [l, r] 的范围中, 选择一个数值作为标定点 pivot
        swap(nums[l], nums[rand() % (r - l + 1) + l]);
        int t = nums[l];
        while (l < r) {
            while (l < r & nums[r] >= t) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r & nums[l] < t) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = t;
        return l;
    }
};

