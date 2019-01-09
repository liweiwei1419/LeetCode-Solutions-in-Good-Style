class Solution:
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        if len(triangle) == 0:
            return 0
        # 这里要多留一个位置，防止数组越界
        dp = [0] * (len(triangle) + 1)
        for i in range(len(triangle) - 1, -1, -1):
            for j in range(i + 1):
                # 【关键】自底向上，每个元素都有左右孩子，就相当于在最后一行加上一行 0
                dp[j] = triangle[i][j] + min(dp[j], dp[j + 1])
            print(dp)
        return dp[0]


if __name__ == '__main__':
    triangle = [[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]]
    # triangle = [[-10]]
    s = Solution()
    res = s.minimumTotal(triangle)
    print(res)
