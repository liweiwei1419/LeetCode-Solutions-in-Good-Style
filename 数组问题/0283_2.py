class Solution:

    # 只有赋值，没有交换

    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """

        not_zero_begin = 0

        for i in range(len(nums)):
            if nums[i] != 0:
                nums[not_zero_begin] = nums[i]
                not_zero_begin += 1

        for i in range(not_zero_begin, len(nums)):
            nums[not_zero_begin] = 0
            not_zero_begin += 1


if __name__ == '__main__':
    s = Solution()
    nums = [0, 1, 0, 3, 12]
    s.moveZeroes(nums)
    print(nums)
