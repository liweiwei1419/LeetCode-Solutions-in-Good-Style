from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:

        stack = []
        maxlength = 0
        pre_max = float("-inf")
        for item in nums:
            while stack and stack[-1] >= item:
                stack.pop()
            stack.append(item)
            if len(stack) > maxlength:
                maxlength = len(stack)
                pre_max = item
            elif item > pre_max:
                maxlength = maxlength + 1
                pre_max = item
        return maxlength

from collections import deque

if __name__ == '__main__':
    nums = [11, 12, 13, 14, 15, 16, 1, 2, 3, 4, 1, 5, 6, 7, 1, 8]
    solution = Solution()
    res = solution.lengthOfLIS(nums)
    print(res)
