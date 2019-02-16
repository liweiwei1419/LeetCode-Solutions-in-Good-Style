# Given nums = [3,2,2,3], val = 3,

class Solution:
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """

        size = len(nums)
        if size == 0:
            return 0

        j = 0
        for i in range(size):
            if nums[i] != val:
                nums[j] = nums[i]
                j += 1
        return j
        # 删除剩余的元素
        # for i in range(len(nums) - j):
        #     nums.pop()


if __name__ == '__main__':
    s = Solution()
    nums = [3, 2, 2, 3]
    val = 3
    s.removeElement(nums, val)
    print(nums)
