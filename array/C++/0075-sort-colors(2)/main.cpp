#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    void sortColors(vector<int> &nums) {
        int size = nums.size();
        if (size < 2) {
            return;
        }

        // all in [0, zero] = 0
        // all in (zero, i) = 1
        // all in (two, len - 1] = 2

        int zero = -1;
        int two = size - 1;
        int i = 0;

        while (i <= two) {
            if (nums[i] == 0) {
                zero++;
                swap(nums[zero], nums[i]);
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums[i], nums[two]);
                two--;
            }
        }
    }
};

