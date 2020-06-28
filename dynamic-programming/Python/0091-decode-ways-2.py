class Solution:
    def numDecodings(self, s: str) -> int:
        size = len(s)
        if size == 0:
            return 0

        # dp[i]：以 s[i - 1] 结尾的前缀字符串的解码个数

        # 分类讨论：
        # 1、s[i] != '0' 时，dp[i + 1] = dp[i]
        # 2、10 <= s[i - 1..i] <= 26 时，dp[i + 1] += dp[i - 1]
        dp = [0 for _ in range(size + 1)]

        if s[0] == '0':
            return 0
        # 作为乘法因子，值为 1
        dp[0] = 1

        if s[0] == '0':
            return 0
        dp[1] = 1

        ord_zero = ord('0')
        for i in range(1, size):
            if s[i] != '0':
                dp[i + 1] = dp[i]

            num = 10 * (ord(s[i - 1]) - ord_zero) + (ord(s[i]) - ord_zero)
            if 10 <= num <= 26:
                dp[i + 1] += dp[i - 1]
        return dp[size]
