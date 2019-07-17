from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        size = len(nums)
        if size == 0:
            return -1
        left = 0
        right = size - 1
        while left < right:
            mid = (left + right + 1) >> 1
            if nums[mid] > target:
                # mid 一定不是目标数，目标数肯定比 mid 小
                right = mid - 1
            else:
                left = mid
        # 后处理，因为目标数有可能不存在在数组中，因此最后单独做判断
        if nums[left] == target:
            return left
        return -1
