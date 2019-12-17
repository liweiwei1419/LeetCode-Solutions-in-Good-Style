from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        size = len(nums)
        if size == 0:
            raise Exception("输入数组不能为空")

        left = 0
        right = size - 1
        while left < right:
            mid = (left + right) >> 1
            if nums[mid] < nums[right]:
                # [5, 1, 2, 3, 4]
                # [4, 5, 1, 2, 3]
                right = mid
            elif nums[mid] > nums[right]:
                # [3,4,5,1,2]
                left = mid + 1
            else:
                right -= 1
        return nums[left]
