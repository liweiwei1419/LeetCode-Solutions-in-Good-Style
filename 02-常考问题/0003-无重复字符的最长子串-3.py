# 滑动窗口
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
            if r + 1 < size and counter[ord(s[r + 1])] == 0:
                # 表示没有重复元素，r 可以加 1
                counter[ord(s[r + 1])] += 1
                r += 1
            else:
                # 有重复元素，左边就要减 1
                counter[ord(s[l])] -= 1
                l += 1
            res = max(res, r - l + 1)
        return res
