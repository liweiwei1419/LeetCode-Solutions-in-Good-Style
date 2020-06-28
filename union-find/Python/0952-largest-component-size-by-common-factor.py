from math import sqrt
from typing import List


class Solution:

    def largestComponentSize(self, A: List[int]) -> int:

        class UnionFind:
            def __init__(self, n):
                self.parent = [i for i in range(n)]

            def union(self, x, y):
                root_x = self.find(x)
                root_y = self.find(y)
                if root_x != root_y:
                    self.parent[root_x] = root_y

            def find(self, x):
                while x != self.parent[x]:
                    self.parent[x] = self.parent[self.parent[x]]
                    x = self.parent[x]
                return x

        max_val = max(A)
        union_find = UnionFind(max_val + 1)

        for num in A:
            up_bound = int(sqrt(num))
            for i in range(2, up_bound + 1):
                if num % i == 0:
                    union_find.union(num, i)
                    union_find.union(num, num // i)

        cnt = [0 for _ in range(max_val + 1)]
        res = 0
        for num in A:
            root = union_find.find(num)
            cnt[root] += 1
            res = max(res, cnt[root])
        return res


if __name__ == '__main__':
    solution = Solution()

    A = [4, 6, 15, 35]
    res = solution.largestComponentSize(A)
    print(res)
