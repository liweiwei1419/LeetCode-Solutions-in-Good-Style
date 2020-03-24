class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        MIN_VALUE = -(1 << 31)
        MAX_VALUE = (1 << 31) - 1
        # 特判
        if divisor == 0:
            return

        if dividend == MIN_VALUE:
            if divisor == 1:
                return MIN_VALUE
            if divisor == -1:
                return MAX_VALUE

        negative = (dividend > 0) ^ (divisor > 0)
        dividend = abs(dividend)
        divisor = abs(divisor)

        max_bit = 0
        while dividend >= divisor:
            divisor <<= 1
            max_bit += 1

        res = 0
        while max_bit > 0:
            max_bit -= 1
            divisor >>= 1
            if divisor <= dividend:
                res += (1 << max_bit)
                dividend -= divisor
        if negative:
            return -res
        return res


if __name__ == '__main__':
    print(0x80000000)

    MIN_VALUE = -(1 << 31)
    MAX_VALUE = (1 << 31) - 1

    print(MIN_VALUE)
    print(MAX_VALUE)
