from typing import List


class Solution:

    # 返回的是大于等于 target 的索引，有可能是最后一个

    def searchInsert(self, nums: List[int], target: int) -> int:
        size = len(nums)
        if size == 0:
            return 0
        left = 0
        right = size
        while left < right:
            # mid = left + (right - left) // 2
            mid = (left + right) >> 1
            if nums[mid] >= target:
                right = mid
            else:
                assert nums[mid] < target
                # [1,5,7] 2
                left = mid + 1
        return left


if __name__ == '__main__':
    nums = [1, 3, 5, 6]
    target = 5
    solution = Solution()
    result = solution.searchInsert(nums, target)
    print(result)
