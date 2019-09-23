class Solution:
    def romanToInt(self, s: str) -> int:
        size = len(s)
        if size == 0:
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
        for i in range(1, size):

            pre = map[s[i - 1]]
            cur = map[s[i]]
            # 这是唯一的一种需要注意的特殊情况，当前面的数字比当前数字要小的时候
            # 要用：当前数字 - 前面数字，因为前面数字加过了，所以要减去 2 倍
            if pre < cur:
                res += (cur - 2 * pre)
            else:
                res += cur
        return res


if __name__ == '__main__':
    solution = Solution()
    s = "LVIII"
    result = solution.romanToInt(s)
    print(result)
