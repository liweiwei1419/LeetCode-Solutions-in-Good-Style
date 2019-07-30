class Solution:
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
                    same = dp[i - 1][j - 1]
                    dp[i][j] = same
                else:
                    m_plus_one = dp[i - 1][j] + 1
                    n_plus_one = dp[i][j - 1] + 1
                    m_n_plus_one = dp[i - 1][j - 1] + 1
                    dp[i][j] = min(m_plus_one, n_plus_one, m_n_plus_one)
        # 调试代码
        # for row in dp:
        #     print(row)
        return dp[m][n]


if __name__ == '__main__':
    word1 = "intention"
    word2 = "execution"

    solution = Solution()
    res = solution.minDistance(word1, word2)
    print(res)
