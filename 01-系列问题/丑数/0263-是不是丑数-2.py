# 263、丑数
# 编写一个程序判断给定的数是否为丑数。
#
# 丑数就是只包含质因数 2, 3, 5 的正整数。


class Solution:
    def isUgly(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num <= 0:
            return False
        factors = [2, 3, 5]
        for factor in factors:
            while num % factor == 0:
                num //= factor
        return num == 1
