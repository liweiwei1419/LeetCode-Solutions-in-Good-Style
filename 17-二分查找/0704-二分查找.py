class Solution:
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        size = len(nums)
        if size == 0:
            return -1

        l = 0
        r = size - 1
        while l <= r:
            mid = l + (r - l) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                # [1,2,3,4,5,6,7,8]
                r = mid - 1
            else:
                l = mid + 1
        return -1
