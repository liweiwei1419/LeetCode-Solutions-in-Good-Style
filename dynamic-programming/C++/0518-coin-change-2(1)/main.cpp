#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    int change(int amount, vector<int> &coins) {
        int len = coins.size();
        vector<vector<int>> dp(len + 1, vector<int>(amount + 1, 0));
        dp[0][0] = 1;
        for (int i = 1; i <= len; ++i) {
            for (int j = 0; j <= amount; ++j) {
                for (int k = 0; j - k * coins[i - 1] >= 0; k++) {
                    dp[i][j] += dp[i - 1][j - k * coins[i - 1]];
                }

            }
        }
        return dp[len][amount];
    }
};

int main() {
    vector<int> coins1 = {1, 2, 5};
    cout << Solution().change(5, coins1) << endl;

    vector<int> coins2 = {2};
    cout << Solution().change(3, coins2) << endl;

    vector<int> coins3 = {10};
    cout << Solution().change(10, coins3) << endl;

    return 0;
}