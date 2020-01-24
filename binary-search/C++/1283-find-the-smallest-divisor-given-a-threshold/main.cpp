#include <iostream>
#include <vector>

using namespace std;

class Solution {

private:
    int calculateSum(vector<int> &nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor;
        }
        return sum;
    }

public:
    int smallestDivisor(vector<int> &nums, int threshold) {
        int maxVal = 1;
        for (int num : nums) {
            maxVal = max(maxVal, num);
        }

        int left = 1;
        int right = maxVal;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (calculateSum(nums, mid) > threshold) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
};