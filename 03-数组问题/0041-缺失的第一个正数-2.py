# 41. 缺失的第一个正数
# 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。

class Solution:

    def firstMissingPositive(self, nums):
        for i in range(len(nums)):
            while 1 <= nums[i] <= len(nums) and nums[i] != nums[nums[i] - 1]:
                self.__swap(nums, i, nums[i] - 1)
        # 添加调试语句
        print(nums)
        for i in range(len(nums)):
            if i + 1 != nums[i]:
                return i + 1
        return len(nums) + 1

    def __swap(self, nums, index1, index2):
        nums[index1], nums[index2] = nums[index2], nums[index1]


if __name__ == '__main__':
    nums = [4, 4, 4, 3, 2, 31, -1, 2]

    solution = Solution()
    res = solution.firstMissingPositive(nums)
    print(res)
