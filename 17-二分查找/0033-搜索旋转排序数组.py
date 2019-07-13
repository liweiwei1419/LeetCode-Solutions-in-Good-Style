# 33. 搜索旋转排序数组
# 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
#
# ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
#
# 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
#
# 你可以假设数组中不存在重复的元素。
#
# 你的算法时间复杂度必须是 O(log n) 级别。
from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        size = len(nums)
        if size == 0:
            return -1

        left = 0
        right = size - 1

        while left <= right:
            # mid = left + (right - left) // 2
            mid = (left + right) >> 1
            if nums[mid] == target:
                return mid

            if nums[mid] < nums[right]:
                # nums[mid + 1:right] 包括左右区间端点有序
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
            else:
                # nums[left:mid - 1] 包括左右区间端点有序
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
        return -1
