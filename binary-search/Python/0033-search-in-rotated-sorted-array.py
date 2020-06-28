class Solution:
    def search(self, nums, target):
        size = len(nums)
        if size == 0:
            return -1

        left = 0
        right = size - 1
        while left < right:
            mid = left + (right - left + 1) // 2

            if nums[mid] < nums[right]:
                if nums[mid] <= target <= nums[right]:
                    left = mid
                else:
                    right = mid - 1
            else:
                # 注意：写这个 if 语句的时候，要让分支和上面一样
                if nums[left] <= target <= nums[mid - 1]:
                    right = mid - 1
                else:
                    left = mid
        return left if nums[left] == target else -1
