from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        size = len(nums)
        # 特判，这一步很重要，否则执行到后序方法可能会出现数组下标越界
        # 同时后序两个方法也不用做特殊判断了
        if size == 0:
            return [-1, -1]

        num1 = self.__find_lower_bound(nums, target)
        # 细节：如果左边界都搜索不到，右边界也没有必要看了
        if num1 == -1:
            return [-1, -1]

        num2 = self.__find_up_bound(nums, target)
        return [num1, num2]

    def __find_lower_bound(self, nums, target):
        # 找大于等于 target 的第 1 个数的索引，小于一定不符合要求
        size = len(nums)

        left = 0
        right = size - 1
        while left < right:
            # 根据分支逻辑，这里选择左中位数
            # mid = left + (right - left) // 2
            mid = (left + right) >> 1
            # 因为找大于等于 target 的第 1 个数，因此小于一定不符合要求
            # 把它写在分支的前面
            if nums[mid] < target:
                left = mid + 1
            else:
                right = mid
        # 因为有可能不存在目标元素，最后一定要单独判断一下
        if nums[left] != target:
            return -1
        return left

    def __find_up_bound(self, nums, target):
        # 找小于等于 target 的最后 1 个数的索引，大于一定不符合要求
        # 因为有可能不存在，最后一定要单独判断一下
        size = len(nums)
        left = 0
        right = size - 1
        while left < right:
            # 根据分支逻辑，这里选择右中位数
            # mid = left + (right - left + 1) // 2
            mid = (left + right + 1) >> 1
            # 因为找小于等于 target 的最后 1 个数，因此大于一定不符合要求
            # 把它写在分支的前面
            if nums[mid] > target:
                right = mid - 1
            else:
                left = mid
        # 因为有可能不存在目标元素，最后一定要单独判断一下
        if nums[left] != target:
            return -1
        return left


if __name__ == '__main__':
    solution = Solution()
    nums = [5, 7, 7, 8, 8, 10]
    target = 8
    result = solution.searchRange(nums, target)
    print(result)
