from typing import List


class Solution:
    def equationsPossible(self, equations: List[str]) -> bool:
        class UnionFind:
            def __init__(self, n):
                self.parent = [i for i in range(n)]

            def find(self, x):
                while x != self.parent[x]:
                    self.parent[x] = self.parent[self.parent[x]]
                    x = self.parent[x]
                return x

            def union(self, x, y):
                root_x = self.find(x)
                root_y = self.find(y)
                self.parent[root_x] = root_y

            def is_connected(self, x, y):
                return self.find(x) == self.find(y)

        unionFind = UnionFind(26)
        for equation in equations:
            if equation[1] == '=':
                index1 = ord(equation[0]) - ord('a')
                index2 = ord(equation[3]) - ord('a')
                unionFind.union(index1, index2)

        for equation in equations:
            if equation[1] == '!':
                index1 = ord(equation[0]) - ord('a')
                index2 = ord(equation[3]) - ord('a')
                if (unionFind.is_connected(index1, index2)):
                    return False
        return True


if __name__ == '__main__':
    solution = Solution()
    equations = ["c==c", "b==d", "x!=z"]
    res = solution.equationsPossible(equations)
    print(res)
