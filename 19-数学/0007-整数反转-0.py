# 给定一个 32 位有符号整数，将整数中的数字进行反转。
class Solution:
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        res = 0

        sign = 1
        if x < 0:
            sign = -1
            x *= sign

        while x != 0:
            res = res * 10 + x % 10
            # Python 中整数除法使用 //
            x //= 10

        if res > 0x7fffffff:
            return 0
        res *= sign

        return res


if __name__ == '__main__':
    solution = Solution()
    reverse = solution.reverse(-123)
    print(reverse)
