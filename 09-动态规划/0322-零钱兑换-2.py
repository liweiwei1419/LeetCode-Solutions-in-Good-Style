class Solution:
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """

        dp = [0] + [-1] * amount

        for x in range(amount + 1):

            if dp[x] == -1:
                continue
            for c in coins:
                if x + c > amount:
                    continue
                if dp[x + c] == -1 or dp[x + c] > dp[x] + 1:
                    dp[x + c] = dp[x] + 1
        return dp[-1]


if __name__ == '__main__':
    coins = [1, 2, 5]
    amount = 11
    solution = Solution()

    result = solution.coinChange(coins, amount)
    print(result)
