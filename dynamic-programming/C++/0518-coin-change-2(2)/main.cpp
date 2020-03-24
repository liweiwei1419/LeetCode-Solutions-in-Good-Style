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
                dp[i][j] = dp[i - 1][j];
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[len][amount];
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}