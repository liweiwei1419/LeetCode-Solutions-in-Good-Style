class Solution(object):

    # 饼干和小朋友的贪心指数都按照“从小到大”的方式进行排序。
    def findContentChildren(self, g, s):
        """
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        """
        g.sort()
        s.sort()
        gi = 0  # 4,5,7
        si = 0  # 3,4,5,6
        res = 0
        while gi < len(g) and si < len(s):
            if s[si] >= g[gi]:
                si += 1
                gi += 1
                res += 1
            else:
                # 丢掉饼干
                si += 1
        return res
