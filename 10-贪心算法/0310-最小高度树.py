class Solution:

    def findMinHeightTrees(self, n, edges):
        if n <= 2:
            return [i for i in range(n)]

        from collections import defaultdict

        in_degrees = [0] * n
        # True 表示保留，如果设置为 False 则表示删除
        res = [True] * n
        # 邻接表
        adjs = defaultdict(list)
        for edge in edges:
            in_degrees[edge[0]] += 1
            in_degrees[edge[1]] += 1
            adjs[edge[0]].append(edge[1])
            adjs[edge[1]].append(edge[0])

        queue = []

        for i in range(n):
            if in_degrees[i] == 1:
                queue.append(i)

        while n > 2:
            size = len(queue)
            n -= size
            for i in range(size):
                top = queue.pop(0)
                res[top] = False

                successors = adjs[top]
                # 它和它的邻接点的入度全部减 1
                successors.append(top)

                for item in successors:
                    in_degrees[item] -= 1
                    if in_degrees[item] == 1:
                        queue.append(item)

        return [i for i in range(len(res)) if res[i]]


if __name__ == '__main__':
    # n = 6
    # edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
    # n = 4
    # edges = [[1, 0], [1, 2], [1, 3]]

    n = 6
    edges = [[0, 1], [0, 2], [0, 3], [3, 4], [4, 5]]

    solution = Solution()

    res = solution.findMinHeightTrees(n, edges)
    print(res)
