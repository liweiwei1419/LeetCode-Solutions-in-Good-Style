class Solution:

    def getSum(self, a: int, b: int) -> int:
        while b:
            # 不进位加法
            temp = a ^ b
            # 考虑进位，同 1 才 1 ，进位体现在左移
            b = (a & b) << 1

            # 在 Python 中，只截取低 32 位，
            # 0xFFFFFFFF 表示的二进制，每个数位都是 1 ，Ox 表示 16 禁止，F 表示 1111，8 个 F 就是 32 个 1
            a = temp & 0xFFFFFFFF
        if a >> 31 == 0:
            return a
        return a - (1 << 32)
