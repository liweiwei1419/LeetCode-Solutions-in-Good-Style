# Given nums = [3,2,2,3], val = 3,

class Solution:
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """

        j = 0
        for i, num in enumerate(nums):
            if num == val:
                # 什么都不做
                pass
            else:
                nums[j] = num
                j += 1
        # 删除剩余的元素
        for i in range(len(nums) - j):
            nums.pop()


if __name__ == '__main__':
    s = Solution()
    nums = [3, 2, 2, 3]
    val = 3
    s.removeElement(nums, val)
    print(nums)
