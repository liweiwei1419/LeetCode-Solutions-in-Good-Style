# 9. 回文数
# 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

# 判断一个整数是否是回文数
class Solution:
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0:
            return False
        # 在执行得到反转的过程中，会改变 x 的值，所以用 x 的副本去完成这个逻辑
        x_copy = x
        res = 0
        while x_copy != 0:
            res = res * 10 + x_copy % 10
            x_copy //= 10
        return res == x


if __name__ == '__main__':
    x = 121
    solution = Solution()
    isPalindrome = solution.isPalindrome(x)
    print(isPalindrome)
