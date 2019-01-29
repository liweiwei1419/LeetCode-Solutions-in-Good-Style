class Solution:

    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n == 0:
            return 0
        dp = [-1] * n

        # 前面这 4 行都是特判
        if n <= 2:
            return max(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        # 状态的定义 dp[i]，考虑 [0,i] （包括物品 i 在内），能够偷取的物品的最大价值
        for i in range(2, n):
            # num[i] 偷和不偷，在这两种情况中选择一种
            dp[i] = max(nums[i] + dp[i - 2], dp[i - 1])
        return dp[-1]


if __name__ == '__main__':
    s = Solution()

    res = s.rob(
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
         0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
         0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0])
    print(res)
