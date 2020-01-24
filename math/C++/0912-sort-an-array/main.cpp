#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> sortArray(vector<int> &nums) {
        int size = 100000;
        vector<int> count(size, 0);
        vector<int> res = nums;
        int len = nums.size();
        for (int i = 0; i < len; ++i) {
            count[nums[i] + 50000]++;
        }
        for (int i = 1; i < size; ++i) {
            count[i] += count[i - 1];
        }
        for (int i = len - 1; i >= 0; --i) {
            res[--count[nums[i] + 50000]] = nums[i];
        }
        return res;
    }
};

