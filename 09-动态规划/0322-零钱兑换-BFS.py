class Solution:
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        # 特判 [2147483647]
        # 2
        if amount <= 0:
            return 0
        coins.sort()
        if coins[0] > amount:
            return -1
        # 不要用数组，用哈希表
        # marked = [False for _ in range(amount)]
        marked = set()

        queue = [(0, amount)]
        while queue:
            # print(queue)
            level, top = queue.pop(0)
            level += 1
            for coin in coins:
                residue = top - coin
                if residue == 0:
                    return level
                if residue > 0 and residue not in marked:
                    queue.append((level, residue))
                    marked.add(residue)
                if residue < 0:
                    # 有了前面排序做保证
                    break
        return -1


if __name__ == '__main__':
    coins = [1, 2, 5]
    amount = 11
    solution = Solution()

    result = solution.coinChange(coins, amount)
    print(result)
