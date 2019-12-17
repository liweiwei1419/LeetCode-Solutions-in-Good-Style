from typing import List


class Solution:

    # 中间元素和右边界比较

    def search(self, nums: List[int], target: int) -> bool:

        size = len(nums)
        if size == 0:
            return False

        left = 0
        right = size - 1
        while left < right:
            mid = (left + right + 1) >> 1
            if nums[mid] < nums[right]:
                # [4, 5, 1, 2, 3]
                if nums[mid] <= target <= nums[right]:
                    left = mid
                else:
                    right = mid - 1
            elif nums[mid] > nums[right]:
                # [3, 4, 5, 1, 2]
                if nums[left] <= target <= nums[mid - 1]:
                    right = mid - 1
                else:
                    left = mid
            else:
                if nums[right] == target:
                    return True
                else:
                    right -= 1
        return nums[left] == target
