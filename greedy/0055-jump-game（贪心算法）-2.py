from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        size = len(nums)
        if size < 2:
            return True
        max_reach = nums[0]
        for i in range(1, size):
            if i > max_reach:
                # 只有这一种情况是 False
                return False
            max_reach = max(max_reach, i + nums[i])
            if max_reach >= size - 1:
                return True
        return False
