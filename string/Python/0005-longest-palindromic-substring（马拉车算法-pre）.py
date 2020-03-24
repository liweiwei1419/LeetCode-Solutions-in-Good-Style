class Solution:
    # Manacher 算法
    def longestPalindrome(self, s: str) -> str:
        # 特判
        size = len(s)
        if size < 2:
            return s

        # 得到预处理字符串
        t = "#"
        for i in range(size):
            t += s[i]
            t += "#"
        # 新字符串的长度
        t_len = 2 * size + 1
        # 当前遍历的中心最大扩散步数，其值等于原始字符串的最长回文子串的长度
        max_len = 1
        # 原始字符串的最长回文子串的起始位置，与 max_len 必须同时更新
        start = 0

        for i in range(t_len):
            cur_len = self.__center_spread(t, i)
            if cur_len > max_len:
                max_len = cur_len
                start = (i - max_len) // 2
        return s[start: start + max_len]

    def __center_spread(self, s, center):
        """
        left = right 的时候，此时回文中心是一条线，回文串的长度是奇数
        right = left + 1 的时候，此时回文中心是任意一个字符，回文串的长度是偶数
        """
        size = len(s)
        i = center - 1
        j = center + 1
        step = 0
        while i >= 0 and j < size and s[i] == s[j]:
            i -= 1
            j += 1
            step += 1
        return step


if __name__ == '__main__':
    s = "babad"
    solution = Solution()
    res = solution.longestPalindrome(s)
    print(res)
