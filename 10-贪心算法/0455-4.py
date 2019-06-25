import heapq


class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g = [(-num, num) for num in g]
        s = [(-num, num) for num in s]
        heapq.heapify(g)
        heapq.heapify(s)

        # 如果最大的饼干都满足不了胃口最大的小朋友，就放弃这个小朋友
        res = 0
        while g and s:
            if s[0][1] >= g[0][1]:
                heapq.heappop(g)
                heapq.heappop(s)
                res += 1
            else:
                heapq.heappop(g)
        return res
