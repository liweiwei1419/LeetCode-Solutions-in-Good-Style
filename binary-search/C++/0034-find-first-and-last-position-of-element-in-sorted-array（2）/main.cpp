#include <iostream>
#include <vector>

using namespace std;


class Solution {
private:
    int findLowerBound(vector<int> &nums, int target) {
        int size = nums.size();
        int left = 0;
        int right = size - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] != target) {
            return -1;
        }
        return left;
    }

    int findUpBound(vector<int> &nums, int target) {
        int size = nums.size();
        int left = 0;
        int right = size - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;

            }
        }
        if (nums[left] != target) {
            return -1;
        }
        return left;
    }


public:
    vector<int> searchRange(vector<int> &nums, int target) {
        int size = nums.size();
        if (size == 0) {
            return {-1, -1};
        }
        int num1 = findLowerBound(nums, target);

        if (num1 == -1) {
            return {-1, -1};
        }
        int num2 = findUpBound(nums, target);
        return {num1, num2};
    }
};

int main() {
    int nums[6] = {5, 7, 7, 8, 8, 10};
    int target = 8;
    vector<int> vec(nums, nums + sizeof(nums) / sizeof(int));
    Solution solution = Solution();
    vector<int> res = solution.searchRange(vec,target);

    for(int e: res){
        cout << e << " ";
    }
    cout << endl;
    return 0;
}