# @Time    : 18/4/9 上午9:50
# 动态规划的解法


class Solution:
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        rows = len(triangle)
        for i in range(1, rows):
            current_cols = len(triangle[i])
            for j in range(current_cols):
                if j == 0:
                    triangle[i][j] = triangle[i][j] + triangle[i - 1][0]
                elif j == (current_cols - 1):
                    triangle[i][j] = triangle[i][j] + triangle[i - 1][j - 1]
                else:
                    triangle[i][j] = min(triangle[i][j] + triangle[i - 1][j - 1],
                                         triangle[i][j] + triangle[i - 1][j])
        return min(triangle[rows - 1])


if __name__ == '__main__':
    triangle = [[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]]
    s = Solution()
    res = s.minimumTotal(triangle)
    print(res)
