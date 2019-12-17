from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        size = len(height)
        if size < 2:
            return 0

        left = 0
        right = size - 1
        res = 0
        while left < right:
            min_h = min(height[left], height[right])
            res = max(res, (right - left) * min_h)
            if min_h == height[left]:
                left += 1
            else:
                right -= 1
        return res


if __name__ == '__main__':
    height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
    solution = Solution()
    result = solution.maxArea(height)
    print(result)
