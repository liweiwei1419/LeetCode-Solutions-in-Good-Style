# 154. 寻找旋转排序数组中的最小值 II
# 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
# ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
# 请找出其中最小的元素。
# 注意数组中可能存在重复的元素。
from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        size = len(nums)
        if size == 0:
            return Exception('程序出错')

        left = 0
        right = size - 1
        while left < right:
            # mid = left + (right - left) // 2
            mid = (left + right) >> 1
            if nums[mid] > nums[right]:
                # mid 肯定不是最小值
                # [7,8,9,10,11,1,2,3]
                left = mid + 1
            elif nums[mid] < nums[right]:
                # mid 有可能是最小值
                # [7,8,1,2,3]
                right = mid
            else:
                # 都有可能，所以就把 right 排除了
                # [1,1,1,1,1,0,1]
                assert nums[mid] == nums[right]
                right = right - 1
        # 无需后处理
        return nums[left]
