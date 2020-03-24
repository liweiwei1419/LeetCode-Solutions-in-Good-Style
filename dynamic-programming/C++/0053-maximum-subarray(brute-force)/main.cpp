#include <iostream>
#include <vector>

using namespace std;

class Solution {

private:
    int sumOfArray(vector<int> &nums, int left, int right) {
        int res = 0;
        for (int i = left; i <= right; ++i) {
            res += nums[i];
        }
        return res;
    }

public:
    int maxSubArray(vector<int> &nums) {
        int size = nums.size();
        int res = INT_MIN;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j <= i; ++j) {
                int sum = sumOfArray(nums, j, i);
                res = max(res, sum);
            }
        }
        return res;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}