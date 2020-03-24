from typing import List


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        size = len(nums)
        if size == 0:
            return 0

        left = 0
        # 因为有可能数组的最后一个元素的位置的下一个是我们要找的，故右边界是 len
        right = size

        while left < right:
            mid = (left + right) >> 1
            # 严格小于 target 的元素一定不是解
            if nums[mid] < target:
                # 下一轮搜索区间是 [mid + 1, right]
                left = mid + 1
            elif nums[mid] == target:
                # 根据本题特殊性，看到等于 target 的元素，返回任意一个即可
                return mid
            else:
                right = mid
        return left
