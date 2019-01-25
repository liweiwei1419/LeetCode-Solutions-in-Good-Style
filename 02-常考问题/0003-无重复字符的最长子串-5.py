class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """

        # 特判
        l = len(s)
        if l < 2:
            return l
        # 隔板法
        # key:字符，val 出现的索引
        map = dict()
        point = 0
        res = 1
        for i in range(l):
            # 关键1：map[s[i]] >= point，等于是可以的
            if s[i] in map and map[s[i]] >= point:
                # 先把隔板向后移动一位
                point = map[s[i]] + 1
            # 然后记录最长不重复子串的长度
            res = max(res, i - point + 1)
            # 关键2：无论如何都更新位置
            map[s[i]] = i
        return res


if __name__ == '__main__':
    s = "abcabcbb"
    solution = Solution()
    result = solution.lengthOfLongestSubstring(s)
    print(result)
