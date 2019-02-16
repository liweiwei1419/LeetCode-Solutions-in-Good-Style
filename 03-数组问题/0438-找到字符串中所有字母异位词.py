class Solution:
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str 模式串
        :rtype: List[int]
        """

        from collections import defaultdict
        hash = defaultdict(int)
        # 滑动窗口的长度
        plen = len(p)
        # 预处理
        for alpha in p:
            hash[alpha] += 1
        # 滑动窗口的左边界
        l = 0
        # 滑动窗口的右边界
        r = 0

        res = []
        # 可以认为是两者的差距
        distance = plen

        while r < len(s):
            if hash[s[r]] > 0:
                distance -= 1
            hash[s[r]] -= 1
            r += 1
            if distance == 0:
                res.append(l)
            if r - l == plen:
                if hash[s[l]] >= 0:
                    distance += 1

                hash[s[l]] += 1
                l += 1
        return res


if __name__ == '__main__':
    s = "cbaebabacd"
    p = "abc"
    solution = Solution()
    result = solution.findAnagrams(s, p)
    print(result)
