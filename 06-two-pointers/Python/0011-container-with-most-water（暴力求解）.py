from typing import List


class Solution:

    # 该解法超时

    def maxArea(self, height: List[int]) -> int:
        size = len(height)
        if size < 2:
            return 0

        res = 0
        for left in range(0, size - 1):
            for right in range(left + 1, size):
                res = max(res, min(height[left], height[right]) * (right - left))
        return res


if __name__ == '__main__':
    height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
    solution = Solution()
    result = solution.maxArea(height)
    print(result)
