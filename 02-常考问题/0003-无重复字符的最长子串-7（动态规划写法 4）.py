class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # 特判
        size = len(s)
        if size < 2:
            return size

        pre = 1
        res = 1
        d = dict()
        d[s[0]] = 0
        # 因为要考虑 pre，索引得从 1 开始，故 d[s[0]] = 0 得先写上
        for i in range(1, size):
            if s[i] in d and pre >= i - d[s[i]]:
                cur = i - d[s[i]]
            else:
                cur = pre + 1
            # 设置字符与索引键值对
            d[s[i]] = i
            res = max(res, cur)
            pre = cur
        # 最后拉通看一遍最大值
        return res


if __name__ == '__main__':
    s = "abcabcbb"
    solution = Solution()
    result = solution.lengthOfLongestSubstring(s)
    print(result)
