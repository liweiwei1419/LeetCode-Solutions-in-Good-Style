# 300. 最长上升子序列
# 给定一个无序的整数数组，找到其中最长上升子序列的长度。


class Solution:

    # 动态规划的思路：将 dp 数组定义为：以 nums[i] 结尾的最长上升子序列的长度
    # 那么题目要求的，就是这个 dp 数组中的最大者
    # 以数组  [10, 9, 2, 5, 3, 7, 101, 18] 为例：
    # dp 的值： 1  1  1  2  2  3  4    4

    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = len(nums)
        if l <= 1:
            return l
        dp = [1] * l
        for i in range(1, l):
            for j in range(i):
                if nums[i] > nums[j]:
                    # + 1 的位置不要加错了
                    dp[i] = max(dp[j] + 1, dp[i])
        # print(dp)
        # 最后要全部走一遍，看最大值
        return max(dp)


if __name__ == '__main__':
    solution = Solution()
    nums = [10, 9, 2, 5, 3, 7, 101, 18]
    result = solution.lengthOfLIS(nums)
    print(result)
