from typing import List


class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        size = len(nums)
        left = 1
        right = size - 1

        while left < right:
            # mid = left + (right - left + 1) // 2
            mid = (left + right + 1) >> 1

            counter = 0
            for num in nums:
                if num < mid:
                    counter += 1

            if counter >= mid:
                # 如果小于 4 的个数等于 4 或者更多
                # 那么重复的数一定位于 1、2、3
                right = mid - 1
            else:
                left = mid

        return left
