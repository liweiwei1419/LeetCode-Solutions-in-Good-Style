class Solution:
    def myAtoi(self, str: str) -> int:
        # 特判
        if str is None or str == '0':
            return 0

        # 1、去掉左右的空格
        str = str.strip()
        size = len(str)

        index = 0

        if size == 0:
            return 0

        sign_char = str[0]
        res = 0

        sign = 1
        if sign_char == '+':
            index += 1
        elif sign_char == '-':
            index += 1
            sign = -1
        elif not sign_char.isdigit():
            return 0

        # MIN_VALUE = 0x80000000
        INT_MIN = -1 << 31
        # MAX_VALUE = 0x7fffffff
        INT_MAX = (1 << 31) - 1

        # 注意越界问题
        for i in range(index, size):
            c = str[i]
            if c.isdigit():
                c_int = ord(c) - ord('0')
                res = res * 10 + c_int
                if res * sign > INT_MAX:
                    break
            else:
                break
        res = res * sign
        if res > INT_MAX:
            return INT_MAX
        elif res < INT_MIN:
            return INT_MIN
        return res
