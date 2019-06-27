# 154. 寻找旋转排序数组中的最小值 II
# 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
# ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
# 请找出其中最小的元素。
# 注意数组中可能存在重复的元素。


class Solution:
    def findMin(self, nums: List[int]) -> int:
        """
        :type nums: List[int]
        :rtype: int
        """
        size = len(nums)
        if size == 0:
            return Exception('程序出错')

        l = 0
        r = size - 1
        while l < r:
            mid = l + (r - l) // 2
            if nums[mid] > nums[r]:
                # mid 肯定不是最小值
                # [7,8,9,10,11,1,2,3]
                l = mid + 1
            elif nums[mid] < nums[r]:
                # mid 有可能是最小值
                # [7,8,1,2,3]
                r = mid
            else:
                # 都有可能，所以就把 r 排除了
                # [1,1,1,1,1,0,1]
                assert nums[mid] == nums[r]
                r = r - 1
        return nums[l]
