#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int change(int amount, vector<int> &coins) {
        int len = coins.size();
        vector<int> dp(amount + 1, 0);
        dp[0] = 1;
        for (int i = 1; i <= len; ++i) {
            for (int j = 0; j <= amount; ++j) {
                if (j - coins[i - 1] >= 0) {
                    dp[j] += dp[j - coins[i - 1]];
                }
            }
        }
        return dp[amount];
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}