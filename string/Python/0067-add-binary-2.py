class Solution:
    def addBinary(self, a: str, b: str) -> str:
        res = ''
        # 分别表示两个数从后向前的索引，后对齐
        i = len(a) - 1
        j = len(b) - 1
        # 表示进位标志
        carry = 0
        while i >= 0 or j >= 0:
            s = carry
            if i >= 0:
                s += ord(a[i]) - ord('0')
                i -= 1
            if j >= 0:
                s += ord(b[j]) - ord('0')
                j -= 1

            res = str(s % 2) + res
            carry = s // 2
        if carry == 1:
            return '1' + res
        return res


if __name__ == '__main__':
    a = '1'
    b = '111'
    solution = Solution()
    result = solution.addBinary(a, b)
    print(result)
