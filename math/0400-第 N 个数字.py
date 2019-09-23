class Solution:
    def findNthDigit(self, n: int) -> int:
        # 特判：如果 n 小于 10 ，直接返回就可以了
        if n < 10:
            return n

        # 表示几位数
        # 2 位数，从 10 到 99 一共 ( 99 - 10 + 1) * 2 = 90 * 2 = 180 位
        # 3 位数，从 100 到 999 一共 ( 999 - 100 + 1) * 2 = 900 * 3 = 2700 位
        # 4 位数，从 1000 到 9999 一共 ( 9999 - 1000 + 1) * 2 = 9000 * 4 = 3600 位

        # 步骤1：calculate how many digits the number has

        # 计算前缀部分
        length = 0
        base = 9
        digits = 1

        # n = 1001 时，9 过，180 过，剩下 812

        # 不越界才加，要清楚这一点
        while length + base * digits < n:
            length += base * digits
            base *= 10
            digits += 1

        n -= length

        # step 2. calculate what the number is
        # 到这里，num 是 "digits 位数" 中的某一个数字
        # 以 digits = 3 为例，n 是 100 - 999 中的一位，num 表示是哪个数字

        index = n % digits

        if index == 0:
            # 如果整除，就是那个数字的最后一位
            num = 10 ** (digits - 1) + n // digits - 1
            return num % 10
        else:
            num = 10 ** (digits - 1) + n // digits
            for i in range(index, digits):
                num //= 10
            return num % 10


if __name__ == '__main__':
    solution = Solution()
    n = 190
    result1 = solution.findNthDigit(n)
    print(result1)
