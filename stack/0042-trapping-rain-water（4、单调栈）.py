from typing import List


class Solution:

    def trap(self, height: List[int]) -> int:
        size = len(height)
        if size < 3:
            return 0
        res = 0
        stack = []
        for i in range(size):
            last = 0
            while stack and height[stack[-1]] <= height[i]:
                top = stack.pop()
                res += (i - top - 1) * (height[top] - last)
                last = height[top]
            if stack:
                res += (height[i] - last) * (i - stack[-1] - 1)
            stack.append(i)
        return res
