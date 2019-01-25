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

        # dp[i] 表示以 s[i] 结尾的最长不重复子串的长度
        # 因为自己肯定是不重复子串，所以初始值设置为 1
        dp = [1 for _ in range(l)]
        map = dict()
        map[s[0]] = 0
        for i in range(1, l):
            if s[i] in map:
                if i - map[s[i]] > dp[i - 1]:
                    dp[i] = dp[i - 1] + 1
                else:
                    dp[i] = i - map[s[i]]
            else:
                dp[i] = dp[i - 1] + 1
            # 设置字符与索引键值对
            map[s[i]] = i
        # 最后拉通看一遍最大值
        return max(dp)


if __name__ == '__main__':
    s = "abcabcbb"
    solution = Solution()
    result = solution.lengthOfLongestSubstring(s)
    print(result)
