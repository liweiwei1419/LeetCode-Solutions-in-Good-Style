#include <iostream>

class Solution {
public:
    int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1;
        int right = x;
        while (left < right) {
            int mid = left + (right - left + 1) >> 1;
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
    std::cout << "Hello, World!" << std::endl;
    return 0;
}