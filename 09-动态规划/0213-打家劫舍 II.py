class Solution:

    def __rob_helper(self, nums):
        n = len(nums)
        if n == 0:
            return 0

        if n <= 2:
            return max(nums)
        dp = [-1] * 2

        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        for i in range(2, n):
            dp[i % 2] = max(nums[i] + dp[(i - 2) % 2], dp[(i - 1) % 2])
        return dp[(n - 1) % 2]

    def rob(self, nums):
        l = len(nums)
        if l == 0:
            return 0
        if l <= 3:
            return max(nums)
        res1 = self.__rob_helper(nums[:-1])
        res2 = self.__rob_helper(nums[1:])
        return max(res1, res2)
