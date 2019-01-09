class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        alen = len(a)
        blen = len(b)
        maxlen = max(alen, blen)
        ra = list(reversed(a))
        rb = list(reversed(b))
        while len(ra) < maxlen:
            ra.append('0')
        while len(rb) < maxlen:
            rb.append('0')

        result = []
        s = 0
        zero = ord('0')
        for i in range(maxlen):
            num1 = ord(ra[i]) - zero
            num2 = ord(rb[i]) - zero
            if s + num1 + num2 > 1:
                result.append(str(s + num1 + num2 - 2))
                s = 1
            else:
                result.append(str(s + num1 + num2))
                s = 0
        if s == 1:
            result.append(str(1))
        return ''.join(list(reversed(result)))


if __name__ == '__main__':
    a = "11"
    b = "1"
    solution = Solution()
    result = solution.addBinary(a, b)
    print(result)
