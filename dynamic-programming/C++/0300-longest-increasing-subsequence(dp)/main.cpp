#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int lengthOfLIS(vector<int> &nums) {
        int size = nums.size();
        vector<int> dp(size);
        for (int i = 0; i < size; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < size; ++i) {
            res = max(res, dp[i]);
        }
        return res;
    }
};

int main() {
    int nums1[] = {10, 9, 2, 5, 3, 7, 101, 18};
    vector<int> vec1(nums1, nums1 + sizeof(nums1) / sizeof(int));
    int res = Solution().lengthOfLIS(vec1);
    cout << res << endl;
}
