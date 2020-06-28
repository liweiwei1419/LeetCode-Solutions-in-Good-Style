from typing import List

class Solution:
    def regionsBySlashes(self, grid: List[str]) -> int:
        n = len(grid) + 1
        edge = n * 4 - 4
        points = n * n
        parent = [i for i in range(points)]

        def union(a, b):
            parent[find(a)] = find(b)

        def find(a):
            if parent[a] != a:
                parent[a] = find(parent[a])
            return parent[a]

        def pos(x, y):
            return x * n + y

        for i in range(n):
            union(pos(0, 0), pos(0, i))
            union(pos(0, 0), pos(n - 1, i))
            union(pos(0, 0), pos(i, 0))
            union(pos(0, 0), pos(i, n - 1))

        for i in range(n - 1):
            for j in range(n - 1):
                if grid[i][j] == '\\':
                    union(pos(i, j), pos(i + 1, j + 1))
                    edge += 1
                elif grid[i][j] == '/':
                    union(pos(i, j + 1), pos(i + 1, j))
                    edge += 1

        components = len([i for i in range(points) if parent[i] == i])

        # print(edge,points,components)
        return edge - points + components
