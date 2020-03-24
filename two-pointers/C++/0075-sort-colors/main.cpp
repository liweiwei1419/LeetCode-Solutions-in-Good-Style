#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    void sortColors(vector<int> &nums) {
        // 循环不变量的定义
        // [0, zero] == 0，表示索引 zero 的值都已经看过，该区间里的元素都等于 0
        // [two, len - 1]，表示索引 two 的值也已经看过，该区间里的元素都等于 2
        int zero = -1;
        int two = nums.size();
        int i = 0;
        while (i < two) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                two--;
                swap(nums[i], nums[two]);
            } else {
                assert(nums[i] == 0);
                zero++;
                swap(nums[zero], nums[i]);
                i++;
            }
        }
    }
};

void printArray(const vector<int> &vec) {
    for (int e: vec) {
        cout << e << " ";
    }
    cout << endl;
}

int main() {
    vector<int> vec1 = {2, 2, 2, 1, 1, 0};
    Solution solution = Solution();
    solution.sortColors(vec1);
    printArray(vec1);

    vector<int> vec2 = {2};
    Solution().sortColors(vec2);
    printArray(vec2);

    return 0;
}