class Solution:
    # 在 Python 语言中，nums 原地修改即可
    def moveZeroes(self, nums):
        """
        # 思路：遇到不是 0 的数，就要冒泡到前面去
        # 重点、难点：循环过程中，保持 [0,j) 这个区间中的元素非零
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """

        j = 0
        for i, num in enumerate(nums):
            if num != 0:
                self.__swap(nums, i, j)
                j += 1
            # print("【{}】".format(i), nums)

    def __swap(self, nums, i, j):
        if i != j:
            temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp


if __name__ == '__main__':
    nums = [0, 1, 3, 5, 0, 4, 6, 3]
    s = Solution()
    s.moveZeroes(nums)
    print(nums)
