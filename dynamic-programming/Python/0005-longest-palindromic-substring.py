class Solution(object):
    def longestPalindrome(self, s):
        if len(s) <= 1:
            return s
        dp = [[False for _ in range(len(s))] for _ in range(len(s))]
        start = 0
        max_len = 1

        for i in range(len(s)):
            dp[i][i] = True

        for i in range(len(s) - 1, -1, -1):
            for j in range(i + 1, len(s)):
                # print_dp(dp)
                if s[i] == s[j]:
                    if j - i < 3:
                        dp[i][j] = True
                    else:
                        dp[i][j] = dp[i + 1][j - 1]
                if dp[i][j]:
                    cur_len = j - i + 1
                    if cur_len > max_len:
                        max_len = cur_len
                        start = i
        return s[start:(start + max_len)]


def print_dp(dp):
    for i in range(len(dp)):
        print(dp[i])
    print()


if __name__ == '__main__':
    solution = Solution()
    s = 'aaaa'
    res = solution.longestPalindrome(s)
    print(res)
