# 参考了别人的解答，不是我自己写的
class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        # sign = x < 0 and -1 or 1

        sign = 1 if x >= 0 else -1

        x = abs(x)
        ans = 0
        while x:
            ans = ans * 10 + x % 10
            # 注意：Python3 要使用整除除法
            x //= 10
        return sign * ans if ans <= 0x7fffffff else 0


if __name__ == '__main__':
    solution = Solution()
    reverse = solution.reverse(-123)
    print(reverse)
