# 13. 罗马数字转整数
class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """

        l = len(s)
        if l == 0:
            return 0
        map = {
            'I': 1,
            'V': 5,
            'X': 10,
            'L': 50,
            'C': 100,
            'D': 500,
            'M': 1000
        }

        res = map[s[0]]
        for i in range(1, l):
            pre = map[s[i - 1]]
            cur = map[s[i]]
            if pre < cur:
                res += (cur - 2 * pre)
            else:
                res += cur
        return res


if __name__ == '__main__':
    solution = Solution()
    s = "LVIII";
    result = solution.romanToInt(s)
    print(result)
