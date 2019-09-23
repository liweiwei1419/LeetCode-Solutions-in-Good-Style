from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        size = len(nums)
        if size == 0:
            return -1
        left = 0
        right = size - 1
        while left < right:
            mid = (left + right) >> 1
            if nums[mid] < target:
                # mid 可以排除，所以要 + 1
                left = mid + 1
            else:
                assert nums[mid] >= target
                # mid 不能排除，所以至少是 mid 这个位置
                right = mid
        # 后处理，为了避免不存在的情况出现，最后要判断一下
        if nums[left] == target:
            return left
        return -1
