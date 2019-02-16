# 53. 最大子序和
# 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。


class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n == 0:
            return 0
        return self.__max_sub_array(nums, 0, n - 1)

    def __max_sub_array(self, nums, left, right):
        if left == right:
            return nums[left]
        mid = left + (right - left) // 2
        return max(self.__max_sub_array(nums, left, mid),
                   self.__max_sub_array(nums, mid + 1, right),
                   self.__max_cross_array(nums, left, mid, right))

    def __max_cross_array(self, nums, left, mid, right):
        """
        一定包含 nums[mid] 元素的最大连续子数组的和
        思路是看看左边扩散到底，得到一个最大数
        右边扩散到底得到一个最大数
        :param nums:
        :param mid:
        :param right:
        :return:
        """
        ls = 0
        j = mid - 1
        s1 = 0
        while j >= left:
            s1 += nums[j]
            ls = max(ls, s1)
            j -= 1

        rs = 0
        j = mid + 1
        s2 = 0
        while j <= right:
            s2 += nums[j]
            rs = max(rs, s2)
            j += 1
        return ls + nums[mid] + rs


if __name__ == '__main__':
    s = Solution()
    nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    result = s.maxSubArray(nums)
    print(result)
