import heapq


class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:

        heapq.heapify(g)
        heapq.heapify(s)

        res = 0
        # 如果小的饼干满足不了贪心指数最小的小朋友，就放弃这个饼干
        while g and s:
            if s[0] >= g[0]:
                heapq.heappop(g)
                heapq.heappop(s)
                res += 1
            else:
                heapq.heappop(s)
        return res


if __name__ == '__main__':
    s = [8, 3, 2, 1]

    heapq.heapify(s)

    print(s)

    heapq.heappop(s)
    print(s)
