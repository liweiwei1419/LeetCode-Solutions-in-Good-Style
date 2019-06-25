class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort(reverse=True) # [4,3,2]
        s.sort(reverse=True) # [3,2,1]
        # 如果最大的饼干都满足不了胃口最大的小朋友，就放弃这个小朋友

        gi = 0
        si = 0
        res = 0

        while gi < len(g) and si < len(s):
            if s[si] >= g[gi]:
                si += 1
                gi += 1
                res += 1
            else:
                gi += 1
        return res
