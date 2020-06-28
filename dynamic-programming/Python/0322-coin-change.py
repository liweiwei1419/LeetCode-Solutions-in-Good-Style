from typing import List


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        def dfs(coins, amount, memo):
            res = 9999
            if amount == 0:
                return 0

            if memo[amount] != -2:
                return memo[amount]

            for coin in coins:

                if amount - coin < 0:
                    break
                sub_res = dfs(coins, amount - coin, memo)
                if sub_res == -1:
                    continue
                res = min(res, sub_res + 1)

            if res == 9999:
                memo[amount] = -1
                return -1
            memo[amount] = res
            return res

        # 因为 -1 是一个特殊的、有意义状态值，因此初值赋值为 -2，表示还未计算
        memo = [-2 for _ in range(amount + 1)]
        # 剪枝方便
        coins.sort()
        return dfs(coins, amount, memo)
