class Solution:
    def combinationSum4(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """

        size = len(nums)
        if size == 0 or target <= 0:
            return 0

        dp = [0 for _ in range(target + 1)]
        dp[0] = 1

        for i in range(1, target + 1):
            for j in range(size):
                if i >= nums[j]:
                    dp[i] += dp[i - nums[j]]

        return dp[-1]


if __name__ == '__main__':
    solution = Solution()
    nums = [1, 2, 3]
    target = 4
    result = solution.combinationSum4(nums, target)
    print(result)
