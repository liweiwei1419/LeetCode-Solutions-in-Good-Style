#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int removeDuplicates(vector<int> &nums) {
        int size = nums.size();
        if (size < 3) {
            return size;
        }

        // [0, j) 表示最终的数组，j 指向下一个要覆盖的元素
        int j = 2;
        for (int i = 2; i < size; ++i) {
            if (nums[i] != nums[j - 2]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
};

