class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort() # [2,3]
        s.sort() # [1,2,3]
        # 如果小的饼干满足不了贪心指数最小的小朋友，就放弃这个饼干

        gi = 0
        si = 0
        res = 0

        while gi < len(g) and si < len(s):
            if s[si] >= g[gi]:
                si += 1
                gi += 1
                res += 1
            else:
                si += 1
        return res

