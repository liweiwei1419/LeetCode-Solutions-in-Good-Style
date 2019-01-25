# 91、解码方法
# 一条包含字母 A-Z 的消息通过以下方式进行了编码：
#
# 'A' -> 1
# 'B' -> 2
# ...
# 'Z' -> 26
# 给定一个只包含数字的非空字符串，请计算解码方法的总数。


class Solution:

    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """

        l = len(s)
        if l == 0:
            return 0

        if l == 1:
            return 1 if s[0] != '0' else 0
        dp = [0 for _ in range(l)]
        dp[0] = 1 if s[0] != '0' else 0
        for i in range(1, l):
            if s[i] != '0':
                # 如果不是 '0' ，那么 s[i] 就可以编码，所以 cur 就至少是  dp[i-1]
                dp[i] += dp[i - 1]
            if 9 < int(s[i - 1:i + 1]) < 27:
                # 可以和前面的数字组成一个编码
                if i - 2 < 0:
                    # 12
                    dp[i] += 1
                else:
                    dp[i] += dp[i - 2]
        return dp[l - 1]


if __name__ == '__main__':
    test_str = '12'
    s = Solution()
    res = s.numDecodings(test_str)
    print(res)
