class Solution:
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """

        # 先把 p 统计一下字母频
        from collections import defaultdict
        wordcount = defaultdict(int)

        for alpha in p:
            wordcount[alpha] += 1

        # 滑动窗口的大小
        plen = len(p)
        slen = len(s)
        l = 0
        r = 0
        same = plen
        res = []
        while r < slen:
            if wordcount[s[r]] > 0:
                # 表示 s[r+1] 在 p 里面
                same -= 1
            wordcount[s[r]] -= 1
            r += 1
            if same == 0:
                res.append(l)
            if r - l == plen:
                if wordcount[s[l]] >= 0:
                    same += 1
                # 左边要出
                wordcount[s[l]] += 1
                l += 1
        return res


if __name__ == '__main__':
    s = "cbaebabacd"
    p = "abc"
    solution = Solution()
    result = solution.findAnagrams(s, p)
    print(result)
