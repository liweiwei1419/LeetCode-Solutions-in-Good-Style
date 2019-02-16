class Solution:

    # 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    # 快速排序的方法，最简单，最直接

    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """

        # 循环不变量保持 [0, j） 保持都非 0，
        # [j, len-1] 为 0
        # j 表示下一个非零元素的位置
        j = 0

        for i in range(len(nums)):
            # 遇到 0 放过，不是 0 的交换到前面去
            if nums[i] != 0:
                nums[j], nums[i] = nums[i], nums[j]
                j += 1


if __name__ == "__main__":
    s = Solution()
    nums = [0, 1, 0, 3, 12]
    s.moveZeroes(nums)
    print(nums)
