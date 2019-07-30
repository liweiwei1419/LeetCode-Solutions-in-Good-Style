class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # 特判
        size = len(s)
        if size < 2:
            return size
        # key 为字符，val 记录了当前读到的字符的索引，在每轮循环的最后更新
        d = dict()
        left = 0
        # 非空的时候，结果至少是 1 ，因此初值可以设置成为 1
        res = 1
        for right in range(size):

            # d[s[right]] >= left，表示重复出现在滑动窗口内
            # d[s[right]] < left 表示重复出现在滑动窗口之外，之前肯定计算过了
            if s[right] in d and d[s[right]] >= left:
                # 下一个不重复的子串至少在之前重复的那个位置之后
                # 【特别注意】快在这个地方，左边界直接跳到之前重复的那个位置之后
                left = d[s[right]] + 1

            # 此时滑动窗口内一定没有重复元素
            res = max(res, right - left + 1)
            # 无论如何都更新位置
            d[s[right]] = right
        return res


if __name__ == '__main__':
    s = "abcabcbb"
    solution = Solution()
    result = solution.lengthOfLongestSubstring(s)
    print(result)
