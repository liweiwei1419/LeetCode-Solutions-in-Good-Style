class Solution:

    # 快排实现：
    # Python 交换数组中的元素，可以用 Python 特殊的语法实现

    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """

        not_zero_end = 0  # 不包括末尾元素
        for j in range(len(nums)):
            if nums[j] != 0:
                nums[not_zero_end], nums[j] = nums[j], nums[not_zero_end]
                not_zero_end += 1


if __name__ == '__main__':
    s = Solution()
    nums = [0, 1, 0, 3, 12]
    s.moveZeroes(nums)
    print(nums)
