# https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/description/

# 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
# 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

# 给你一个已经排好序的数组，删除重复的元素，是原地删除，相同元素只保留一个，返回数组的长度。
# 应该充分利用排好序的数组这个特性来完成。
# 应该注意到一些特殊的测试用例，例如 nums = [] 的时候。注意，题目要求返回新数组的长度。
class Solution:
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0

        current_num = nums[0]
        j = 1
        for i in range(1, len(nums)):
            if nums[i] == current_num:
                pass
            else:  # 如果不一样
                current_num = nums[i]
                nums[j] = nums[i]
                j += 1

        for i in range(len(nums) - j):
            nums.pop()

        return j


if __name__ == '__main__':
    s = Solution()
    nums = [1, 1, 1, 1, 1, 2, 2]
    # nums = [1, 1, 2]
    # nums = []
    res = s.removeDuplicates(nums)
    print(nums)
    print(res)
