class Solution:

    # 状态定义很关键，类似状态定义的技巧 LeetCode 第 10 题
    # dp[i][j]：word1 的前 i 个字符匹配到 word2 的前 j 个字符的最少操作数。

    def minDistance(self, word1: str, word2: str) -> int:
        m = len(word1)
        n = len(word2)

        dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]

        for i in range(m + 1):
            dp[i][0] = i

        for j in range(n + 1):
            dp[0][j] = j

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if word1[i - 1] == word2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    m_plus_one = dp[i - 1][j] + 1
                    n_plus_one = dp[i][j - 1] + 1
                    m_change_one = dp[i - 1][j - 1] + 1
                    dp[i][j] = min(m_plus_one, n_plus_one, m_change_one)
        return dp[m][n]


if __name__ == '__main__':
    word1 = "intention"
    word2 = "execution"

    solution = Solution()
    res = solution.minDistance(word1, word2)
    print(res)
