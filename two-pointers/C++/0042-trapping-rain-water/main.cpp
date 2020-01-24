#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int trap(vector<int> &height) {

        // 双指针写法

        int size = height.size();
        if (size < 3) {
            return 0;
        }

        int left = 0;
        int right = size - 1;
        int leftMax = height[left];
        int rightMax = max(height[left], height[right]);
        int res = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                res += min(leftMax, rightMax) - height[left];
                left++;
                leftMax = max(leftMax, height[left]);
            } else {
                res += min(leftMax, rightMax) - height[right];
                right--;
                rightMax = max(rightMax, height[right]);
            }
        }
        return res;
    }
};

int main() {
    vector<int> height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    Solution solution = Solution();
    int res = solution.trap(height);
    std::cout << res << std::endl;
    return 0;
}
