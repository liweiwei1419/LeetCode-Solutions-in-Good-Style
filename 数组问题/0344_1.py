class Solution(object):

    # 【注意】这种写法是错的，字符串不能被修改

    def reverseString(self, s):
        """
        :type s: str
        :rtype: str
        """
        if len(s) < 2:
            return s

        left = 0
        right = len(s) - 1
        # print(s[left])
        while left < right:
            s[left], s[right] = s[right], s[left]
            left += 1
            right -= 1
        return s


if __name__ == '__main__':
    s = 'hello'
    solution = Solution()
    result = solution.reverseString(s)
    print(result)
