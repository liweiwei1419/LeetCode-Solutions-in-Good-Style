from typing import List


class Solution:
    def smallestDivisor(self, nums: List[int], threshold: int) -> int:
        left = 1
        right = max(nums)

        while left < right:
            mid = (left + right) >> 1
            if sum([(num + mid - 1) // mid for num in nums]) > threshold:
                left = mid + 1
            else:
                right = mid
        return left