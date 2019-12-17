from typing import List


class Solution:

    def trap(self, height: List[int]) -> int:
        size = len(height)
        if size < 3:
            return 0

        # 注意：这里与 height[i] 比较的含义
        left_max = [0] * size
        for i in range(1, size):
            left_max[i] = max(left_max[i - 1], height[i])

        right_max = [0] * size
        for i in range(size - 2, -1, -1):
            right_max[i] = max(right_max[i + 1], height[i])

        res = 0

        for i in range(size - 1):
            # 由遍历过程可以知道，left_max[i] 和 right_max[i] 都大于等于 height[i]
            res += min(left_max[i], right_max[i]) - height[i]
        return res