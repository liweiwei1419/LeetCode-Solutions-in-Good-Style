class Solution:

    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        dp = [1] * n
        for i in range(1, m):
            for j in range(1, n):  # 从索引 2 开始走就行了
                dp[j] = dp[j] + dp[j - 1]
        return dp[-1]


if __name__ == '__main__':
    s = Solution()
    res = s.uniquePaths(5, 4)
    print(res)
