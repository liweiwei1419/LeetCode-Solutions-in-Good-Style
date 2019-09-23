from typing import List


class Solution:

    # 直接的并查集版本

    def findCircleNum(self, M: List[List[int]]) -> int:
        class UnionFind:
            def __init__(self, n):
                self.parent = [i for i in range(n)]

            def find(self, p):
                root = p
                while root != self.parent[root]:
                    root = self.parent[root]
                while p != self.parent[p]:
                    temp = self.parent[p]
                    self.parent[p] = root
                    p = temp
                return root

            def is_connected(self, p, q):
                return self.find(p) == self.find(q)

            def union(self, p, q):
                p_id = self.find(p)
                q_id = self.find(q)
                if p_id == q_id:
                    return
                self.parent[p_id] = q_id

        m = len(M)
        union_find_set = UnionFind(m)
        for i in range(m):
            for j in range(i):
                if M[i][j] == 1:
                    union_find_set.union(j, i)
        counter = 0
        # print(union_find_set.parent)
        # 自己的父亲是自己的话，这个结点就是根结点，是老大，是 boss
        # boss 的特点就是，他上面没有人，例如：李彦宏、马云
        # 数一数有几个老大，就有几个朋友圈
        for index, parent in enumerate(union_find_set.parent):
            if index == parent:
                counter += 1
        return counter


if __name__ == '__main__':
    M = [[1, 1, 0],
         [1, 1, 0],
         [0, 0, 1]]

    solution = Solution()
    result = solution.findCircleNum(M)
    print(result)
