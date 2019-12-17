from typing import List


class Solution:

    # 中间元素和左边界比较

    def search(self, nums: List[int], target: int) -> bool:
        size = len(nums)
        if size == 0:
            return False

        left = 0
        right = size - 1
        while left < right:
            mid = (left + right + 1) >> 1
            if nums[left] < nums[mid]:
                # [2, 3, 4, 1, 2]
                if nums[left] <= target <= nums[mid - 1]:
                    right = mid - 1
                else:
                    left = mid
            elif nums[left] > nums[mid]:
                # [4, 5, 1, 2, 3]
                if nums[mid] <= target <= nums[right]:
                    left = mid
                else:
                    right = mid - 1
            else:
                if nums[left] == target:
                    return True
                else:
                    left += 1
        return nums[left] == target
