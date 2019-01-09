# 53. 最大子序和
# 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = len(nums)
        if l == 0:
            return 0
        # 以索引 i 结尾的最大子数组的和
        end_i_max = nums[0]
        # 最后返回的数
        res = nums[0]
        for i in range(1, l):
            # 例：[-3,1]
            end_i_max = max(nums[i], end_i_max + nums[i])
            res = max(res, end_i_max)
        return res


if __name__ == '__main__':
    s = Solution()
    nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    result = s.maxSubArray(nums)
    print(result)
