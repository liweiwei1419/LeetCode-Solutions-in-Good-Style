class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """

        # 特判
        size = len(s)
        if size < 2:
            return size
        l = 0
        r = -1
        counter = [0 for _ in range(256)]

        res = 1
        while l < size:
            # 首先"右指针"不断向右边尝试，走到出现重复的最右边
            while r + 1 < size and counter[ord(s[r + 1])] == 0:
                # 表示没有重复元素，r 可以加 1
                counter[ord(s[r + 1])] += 1
                r += 1
            # 此时，记录不重复子串是"左指针"固定时候最长
            res = max(res, r - l + 1)
            # 考虑移动"左指针"
            # 此时 s[r+1] 就是已经扫过的区间里重复的元素，要把它剔除出去
            while r + 1 < size and s[l] != s[r + 1]:
                # 有重复元素，左边就要减 1
                counter[ord(s[l])] -= 1
                l += 1
            # 出了上一个循环以后，还要再把左指针向右移动一格，否则右指针不能向右移动
            counter[ord(s[l])] -= 1
            l += 1
        return res


if __name__ == '__main__':
    s = "abcabcbb"
    solution = Solution()
    result = solution.lengthOfLongestSubstring(s)
    print(result)
