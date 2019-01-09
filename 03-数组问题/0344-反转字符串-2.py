class Solution(object):

    def reverseString(self, s):
        """
        :type s: str
        :rtype: str
        """
        if len(s) < 2:
            return s

        left = 0
        right = len(s) - 1
        l = list(s)
        while left < right:
            l[left], l[right] = l[right], l[left]
            left += 1
            right -= 1
        return ''.join(l)


if __name__ == '__main__':
    s = 'hello'
    solution = Solution()
    result = solution.reverseString(s)
    print(result)
