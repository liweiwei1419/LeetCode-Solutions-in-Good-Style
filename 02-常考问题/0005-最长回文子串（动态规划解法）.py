# 5. 最长回文子串
# 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

class Solution:
    def longestPalindrome(self, s: str) -> str:
        size = len(s)
        if size <= 1:
            return s
        # 二维 dp 问题
        # 状态：dp[i,j]: s[i:j] 包括 i，j ，表示的字符串是不是回文串
        dp = [[False for _ in range(size)] for _ in range(size)]

        longest_l = 1
        res = s[0]

        for i in range(size):
            for j in range(i):
                # 状态转移方程：如果头尾字符相等并且中间也是回文
                # 或者中间的长度小于等于 1
                if s[j] == s[i] and (i - j <= 2 or dp[j + 1][i - 1]):
                    dp[j][i] = True
                    if i - j + 1 > longest_l:
                        longest_l = i - j + 1
                        res = s[j:i + 1]

        for item in dp:
            print(item)
        return res


if __name__ == '__main__':
    solution = Solution()
    s = 'aaaaaa'
    result = solution.longestPalindrome(s)
    print(result)
