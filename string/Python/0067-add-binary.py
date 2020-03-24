class Solution:
    def addBinary(self, a: str, b: str) -> str:
        a_len = len(a)
        b_len = len(b)
        max_len = max(a_len, b_len)
        ra = list(reversed(a))
        rb = list(reversed(b))
        while len(ra) < max_len:
            ra.append('0')
        while len(rb) < max_len:
            rb.append('0')

        res = []
        carry = 0
        zero = ord('0')
        for i in range(max_len):
            num1 = ord(ra[i]) - zero
            num2 = ord(rb[i]) - zero
            if carry + num1 + num2 > 1:
                res.append(str(carry + num1 + num2 - 2))
                carry = 1
            else:
                res.append(str(carry + num1 + num2))
                carry = 0
        if carry == 1:
            res.append(str(1))
        return ''.join(list(reversed(res)))


if __name__ == '__main__':
    a = "11"
    b = "1"
    solution = Solution()
    result = solution.addBinary(a, b)
    print(result)
