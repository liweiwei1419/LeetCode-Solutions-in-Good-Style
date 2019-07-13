from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        size = len(nums)
        if size == 0:
            return -1
        left = 0
        right = size - 1
        while left < right:
            # mid = left + (right - left + 1) // 2
            mid = (left + right + 1) >> 1
            if nums[mid] <= target:
                # mid 在，因此，不能排除 mid
                left = mid
            else:
                assert nums[mid] > target
                # mid 不在，所以可以排除 mid
                right = mid - 1
        # 后处理，为了避免不存在的情况出现，最后要判断一下
        if nums[left] == target:
            return left
        return -1
