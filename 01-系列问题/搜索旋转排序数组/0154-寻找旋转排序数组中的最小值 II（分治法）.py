# 154. 寻找旋转排序数组中的最小值 II
# 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
# ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
# 请找出其中最小的元素。
# 注意数组中可能存在重复的元素。


class Solution:
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        size = len(nums)
        if size == 0:
            raise Exception('程序出错')
        if size == 1:
            return nums[0]
        return self.__findMin(nums, 0, size - 1)

    def __findMin(self, nums, left, right):
        if left == right:
            return nums[left]
        if left + 1 == right:
            return min(nums[left], nums[right])
        mid = left + (right - left) // 2
        return min(self.__findMin(nums, left, mid), self.__findMin(nums, mid + 1, right))
