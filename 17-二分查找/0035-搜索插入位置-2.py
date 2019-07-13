from typing import List


class Solution:

    def searchInsert(self, nums: List[int], target: int) -> int:
        # 返回大于等于 target 的索引，有可能是最后一个
        size = len(nums)
        # 特判 1
        if size == 0:
            return 0
        # 特判 2：如果比最后一个数字还要大，直接接在它后面就可以了
        if target > nums[-1]:
            return size

        left = 0
        right = size - 1
        # 二分的逻辑一定要写对，否则会出现死循环或者数组下标越界
        while left < right:
            # mid = left + (right - left) // 2
            mid = (left + right) >> 1
            if nums[mid] < target:
                left = mid + 1
            else:
                assert nums[mid] >= target
                right = mid
        return left


if __name__ == '__main__':
    # nums = [1, 3, 5, 6]
    nums = [1, 2, 3, 5, 5, 5]

    target = 5
    solution = Solution()
    result = solution.searchInsert(nums, target)
    print('结果：', result)
