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
        left = 0
        right = 0
        same = plen
        res = []
        while right < slen:
            if wordcount[s[right]] > 0:
                # 表示 s[right+1] 在 p 里面
                same -= 1
            wordcount[s[right]] -= 1
            right += 1
            if same == 0:
                res.append(left)
            if right - left == plen:
                if wordcount[s[left]] >= 0:
                    same += 1
                # 左边要出
                wordcount[s[left]] += 1
                left += 1
        return res


if __name__ == '__main__':
    s = "cbaebabacd"
    p = "abc"
    solution = Solution()
    result = solution.findAnagrams(s, p)
    print(result)
