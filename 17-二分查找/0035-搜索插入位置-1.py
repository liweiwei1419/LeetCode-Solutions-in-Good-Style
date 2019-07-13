from typing import List


class Solution:

    def searchInsert(self, nums: List[int], target: int) -> int:
        # 返回大于等于 target 的索引，有可能是最后一个
        size = len(nums)
        # 特判
        if size == 0:
            return 0

        left = 0
        # 如果 target 比 nums里所有的数都大，则最后一个数的索引 + 1 就是候选值，因此，右边界应该是数组的长度
        right = size
        # 二分的逻辑一定要写对，否则会出现死循环或者数组下标越界
        while left < right:
            # mid = left + (right - left) // 2
            mid = (left + right) >> 1
            if nums[mid] < target:
                left = mid + 1
            else:
                assert nums[mid] >= target
                # [1,5,7] 2
                right = mid
        # 调试语句
        # print('left = {}, right = {}, mid = {}'.format(left, right, mid))
        return left


if __name__ == '__main__':
    # nums = [1, 3, 5, 6]
    nums = [1, 2, 3, 5, 5, 5]

    target = 5
    solution = Solution()
    result = solution.searchInsert(nums, target)
    print('结果：', result)
