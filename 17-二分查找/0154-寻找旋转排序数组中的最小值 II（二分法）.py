# 154. 寻找旋转排序数组中的最小值 II
# 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
# ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
# 请找出其中最小的元素。
# 注意数组中可能存在重复的元素。
from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        size = len(nums)
        # 根据题意，没有必要单独判断 size = 0 的情况

        left = 0
        right = size - 1
        while left < right:
            # mid = left + (right - left) // 2
            mid = (left + right) >> 1

            if nums[left] > nums[mid]:
                # [9,1,2,3, 4, 5,6,7,8]
                #          mid
                # mid 的右边可以被排除了，但它自己有可能是目标数值
                right = mid
            elif nums[left] < nums[mid]:
                # [1,2,3]
                # [2,3,1]
                # [2,3,4,5, 6, 7,8,9,1]
                #          mid
                left = mid + 1
            else:
                assert nums[left] == nums[mid]
                # [1,1,1,1,1,0,1,1,1]
                left = left + 1
        # 无需后处理
        return nums[left]


if __name__ == '__main__':
    solution = Solution()
    nums = [1, 3, 5]
    res = solution.findMin(nums)
    print(res)
