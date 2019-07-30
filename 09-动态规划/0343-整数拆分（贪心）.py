class Solution:
    def integerBreak(self, n):
        if n == 2:
            return 1
        if n == 3:
            return 2
        if n == 4:
            return 4
        res = 1
        while n > 4:
            res *= 3
            n -= 3

        res *= n
        return res


if __name__ == '__main__':
    n = 10
    s = Solution()
    res = s.integerBreak(n)
    print(res)
