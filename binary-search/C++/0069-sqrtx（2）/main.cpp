#include <iostream>

class Solution {
public:
    int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        // 针对一些大的测试用例，将 left 和 right 设置为 long 类型
        int left = 1;
        int right = x / 2;
        while (left < right) {
            // C++ 中没有无符号右移，写成 >> 也能通过，不知道为什么
            int mid = (left + right + 1) >> 1;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
};


int main() {
    Solution solution = Solution();

    int x = 2147395599;
    int res = solution.mySqrt(x);

    std::cout << res << std::endl;
    return 0;
}