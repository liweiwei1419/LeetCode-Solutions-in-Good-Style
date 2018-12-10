class Solution:
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        j = 0
        for i in range(len(nums)):
            if nums[i] != val:
                nums[j] = nums[i]
                j += 1
        return j


if __name__ == '__main__':
    nums = [3, 2, 2, 3]
    val = 3
    s = Solution()
    result = s.removeElement(nums, val)
    print(nums)
    print(result)
