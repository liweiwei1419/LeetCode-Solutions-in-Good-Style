#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int missingNumber(vector<int> &nums) {
        int size = nums.size();
        int sum = 0;

        for (int j = 1; j <= size; ++j) {
            sum += j;
        }

        for (int i = 0; i < size; ++i) {
            sum -= nums[i];
        }
        return sum;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}