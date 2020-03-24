class Solution:

    def __first_match(self, s, p, i, j):
        return s[i] == p[j] or p[j] == '.'

    def isMatch(self, s: str, p: str) -> bool:
        s_len = len(s)
        p_len = len(p)

        dp = [[False for _ in range(p_len + 1)] for _ in range(s_len + 1)]
        dp[0][0] = True

        for j in range(2, p_len + 1):
            dp[0][j] = (p[j - 1] == '*' and dp[0][j - 2])

        for i in range(s_len):
            for j in range(p_len):
                if p[j] == '*':
                    if dp[i + 1][j - 1]:
                        dp[i + 1][j + 1] = True
                    else:
                        dp[i + 1][j + 1] = self.__first_match(s, p, i, j - 1) and dp[i][j + 1]
                else:
                    dp[i + 1][j + 1] = self.__first_match(s, p, i, j) and dp[i][j]

        return dp[s_len][p_len]
