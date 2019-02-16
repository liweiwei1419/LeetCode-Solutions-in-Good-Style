class Solution:
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """

        # 特判
        size = len(coins)
        if size == 0:
            return -1

        dp = [0 for _ in range(amount + 1)]

        for i in range(1, amount + 1):
            min_val = 9999
            for j in range(0, size):
                if i - coins[j] >= 0 and dp[i - coins[j]] != -1:
                    min_val = min(min_val, dp[i - coins[j]] + 1)
            if min_val == 9999:
                dp[i] = -1
            else:
                dp[i] = min_val

        return dp[-1]


if __name__ == '__main__':
    coins = [1, 2, 5]
    amount = 11
    solution = Solution()

    result = solution.coinChange(coins, amount)
    print(result)
