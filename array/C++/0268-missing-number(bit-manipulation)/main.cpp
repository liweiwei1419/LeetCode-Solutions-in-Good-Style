#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int missingNumber(vector<int> &nums) {
        int size = nums.size();
        int res = 0;

        for (int i = 0; i < size; ++i) {
            res ^= nums[i];
        }

        for (int j = 1; j <= size; ++j) {
            res ^= j;
        }
        return res;
    }
};