class Solution:
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        l = 0
        r = len(height) - 1
        res = 0
        while l < r:
            min_h = min(height[l], height[r])
            res = max(res, (r - l) * min_h)
            if min_h == height[l]:
                l += 1
            else:
                r -= 1
        return res


if __name__ == '__main__':
    height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
    solution = Solution()
    result = solution.maxArea(height)
    print(result)
