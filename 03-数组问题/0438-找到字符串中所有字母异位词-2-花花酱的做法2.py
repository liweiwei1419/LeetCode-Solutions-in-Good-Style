class Solution:
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """

        # 滑动窗口的大小
        plen = len(p)
        slen = len(s)

        scnt = [0] * 26
        pcnt = [0] * 26

        res = []
        for alpha in p:
            pcnt[ord(alpha) - ord('a')] += 1

        for end in range(slen):
            scnt[ord(s[end]) - ord('a')] += 1
            if end >= plen - 1:
                if scnt == pcnt:
                    res.append(end - plen + 1)
                scnt[ord(s[end - plen + 1]) - ord('a')] -= 1
        return res


if __name__ == '__main__':
    s = "cbaebabacd"
    p = "abc"
    solution = Solution()
    result = solution.findAnagrams(s, p)
    print(result)
