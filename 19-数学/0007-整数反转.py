# 7. 整数反转
# 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

class Solution:
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x == 0:
            return 0
        sign = 1 if x > 0 else -1
        x = sign * x
        ans = 0
        while x > 0:
            ans = ans * 10 + (x % 10)
            x //= 10
        return sign * ans if ans < 0x7fffffff else 0


if __name__ == '__main__':
    x = -123

    solution = Solution()
    result = solution.reverse(x)
    print(result)
