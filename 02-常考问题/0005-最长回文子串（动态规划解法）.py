# 5. 最长回文子串
# 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        l = len(s)
        if l <= 1:
            return s
        dp = [[False for _ in range(l)] for _ in range(l)]

        longest_l = 1
        res = s[0]

        for i in range(l):
            for j in range(i + 1):
                if s[j] == s[i] and (j >= i - 2 or dp[j + 1][i - 1]):
                    dp[j][i] = True
                    if i - j + 1 > longest_l:
                        longest_l = i - j + 1
                        res = s[j:i + 1]
        return res


if __name__ == '__main__':
    solution = Solution()
    s = 'babad'
    result = solution.longestPalindrome(s)
    print(result)
