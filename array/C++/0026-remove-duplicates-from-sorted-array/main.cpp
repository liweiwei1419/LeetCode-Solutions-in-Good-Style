#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int removeDuplicates(vector<int> &nums) {
        int size = nums.size();
        if (size < 2) {
            return size;
        }

        // 循环不变量：[0, j) 是删除了重复元素以后得到的新数组
        int j = 1;
        for (int i = 1; i < size; ++i) {
            if (nums[i] != nums[j - 1]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
};
