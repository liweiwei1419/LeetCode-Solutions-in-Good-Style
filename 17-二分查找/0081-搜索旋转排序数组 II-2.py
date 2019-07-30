# 81. 搜索旋转排序数组 II
# 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
#
# ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
#
# 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。


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
            mid = (left + right) >> 1
            if nums[mid] > nums[left]:
                if nums[left] <= target <= nums[mid]:
                    # 落在前有序数组里
                    right = mid
                else:
                    left = mid + 1
            elif nums[mid] < nums[left]:
                # 让分支和上面分支一样
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid
            else:
                # 要排除掉左边界之前，先看一看左边界可以不可以排除
                if nums[left] == target:
                    return True
                left = left + 1
        # 后处理，夹逼以后，还要判断一下，是不是 target
        return nums[left] == target
