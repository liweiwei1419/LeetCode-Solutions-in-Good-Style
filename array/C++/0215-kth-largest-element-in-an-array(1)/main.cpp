#include <iostream>
#include <vector>

using namespace std;

class Solution {
private:
    int partition(vector<int> &nums, int left, int right) {
        // 随机在 [left, right] 中, 选择一个数值作为标定点 pivot
        swap(nums[left], nums[rand() % (right - left + 1) + left]);

        int pivot = nums[left];
        while (left < right) {
            while (left < right & nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right & nums[left] < pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

public:
    int findKthLargest(vector<int> &nums, int k) {
        int size = nums.size();
        int target = size - k;

        int left = 0;
        int right = size - 1;
        while (true) {
            int p = partition(nums, left, right);
            if (p == target) {
                return nums[p];
            } else if (target < p) {
                right = p - 1;
            } else {
                left = p + 1;
            }
        }
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
