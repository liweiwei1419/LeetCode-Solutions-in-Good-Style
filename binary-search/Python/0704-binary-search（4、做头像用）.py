class Solution:
    def search(self, nums, target):
        size = len(nums)
        if size == 0:
            return -1
        left = 0
        right = size - 1
        while left < right:
            mid = (left + right + 1) // 2

            if nums[mid] > target:
                right = mid - 1
            else:
                left = mid
        if nums[left] == target:
            return left
        return -1
