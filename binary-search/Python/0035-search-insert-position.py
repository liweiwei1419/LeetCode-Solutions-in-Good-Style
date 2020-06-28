from typing import List


class Solution:

    def searchInsert(self, nums: List[int], target: int) -> int:
        size = len(nums)
        if size == 0:
            return 0
        if nums[size - 1] < target:
            return size
        left = 0
        right = size - 1
        while left < right:
            mid = (left + right) // 2
            if nums[mid] >= target:
                # 严格大于 target 的时候，mid 以及 mid 的左边都有可能是插入元素的位置
                # 此时还应该把等于 target 的时候算进去，或者单独写一个分支
                # 因此下一轮搜索的区间是 [left, mid]，此时边界的收缩行为是 right = mid
                right = mid
            else:
                # if 的反面，即搜索区间是 [mid + 1, right]
                # 此时边界的收缩行为是 left = mid + 1
                # 中间数取整行为无须调整
                left = mid + 1
        return left
