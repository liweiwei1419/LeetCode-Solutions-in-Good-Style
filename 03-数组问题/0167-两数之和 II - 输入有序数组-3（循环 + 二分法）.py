# 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
#
# 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
#
# 说明:
#
# 返回的下标值（index1 和 index2）不是从零开始的。
# 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
# 示例:
#
# 输入: numbers = [2, 7, 11, 15], target = 9
# 输出: [1,2]
# 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
from typing import List


class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        size = len(numbers)
        for left in range(size - 1):
            right = self.__binary_search(numbers, left + 1, size - 1, target - numbers[left])
            if right != -1:
                return [left + 1, right + 1]

    def __binary_search(self, numbers, left, right, target):
        # 在子区间 [left, right] 找 target
        while left < right:
            mid = (left + right) >> 1
            if numbers[mid] < target:
                left = mid + 1
            else:
                right = mid
        return left if numbers[left] == target else -1


if __name__ == '__main__':
    numbers = [2, 7, 11, 15]
    target = 9

    solution = Solution()
    res = solution.twoSum(numbers, target)
    print(res)
