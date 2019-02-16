class Solution:
    def findTargetSumWays(self, nums, S):
        """
        :type nums: List[int]
        :type S: int
        :rtype: int
        """
        size = len(nums)
        ss = sum(nums)
        target = ss + S
        if size == 0 or target & 1:
            return 0

        # 除以 2
        target >>= 1
        # 因为题目中给出的是非负整数，因此这一步可以提前判断是否有解
        if target > ss:
            return 0

        dp = [[0 for _ in range(target + 1)] for _ in range(size)]

        # 这一步不要忘记了
        dp[0][0] = 1
        for j in range(target + 1):
            if nums[0] == j:
                dp[0][j] += 1

        for i in range(1, size):
            for j in range(target + 1):
                # 至少是不选这个物品时候的种数
                dp[i][j] += dp[i - 1][j]
                if j >= nums[i]:
                    dp[i][j] += dp[i - 1][j - nums[i]]
        return dp[-1][-1]


if __name__ == '__main__':
    solution = Solution()
    # nums = [1, 1, 1, 1, 1]
    # S = 3
    nums = [35, 25, 24, 23, 2, 47, 39, 22, 3, 7, 11, 26, 6, 30, 5, 34, 10, 43, 41, 28]
    S = 49
    result = solution.findTargetSumWays(nums, S)
    print(result)
