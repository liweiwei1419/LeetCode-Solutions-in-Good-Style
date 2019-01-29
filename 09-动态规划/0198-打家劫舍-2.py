class Solution:
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        l = len(nums)
        if l == 0:
            return 0
        if l == 1:
            return nums[0]
        if l == 2:
            return max(nums[0], nums[1])
        dp = [0 for _ in range(l)]
        # dp[i] = max(dp[i-1],nums[i]+dp[i-2])
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2, l):
            dp[i] = max(dp[i - 1], nums[i] + dp[i - 2])
        return dp[l - 1]
