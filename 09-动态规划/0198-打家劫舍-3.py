# @Time    : 18/4/11 下午1:07


class Solution:

    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
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
