from typing import List


class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        if n <= 2:
            return [i for i in range(n)]

        from collections import defaultdict
        from collections import deque

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

        deque = deque()
        for i in range(n):
            if in_degrees[i] == 1:
                deque.append(i)

        # 根据示例，可知，最后可能剩下 1 个结点或者 2 个结点
        # 或者自己画一个图也能分析出来
        while n > 2:
            size = len(deque)
            # 一次减去当前队列这么多个结点
            n -= size
            for i in range(size):
                top = deque.popleft()
                res[top] = False

                successors = adjs[top]
                # 它和它的邻接点的入度全部减 1
                in_degrees[top] -= 1

                for item in successors:
                    # 一个结点的入度重复减是没有关系的
                    # 我们只关心在最边界的那个结点，把它移除，所以可以认为是贪心法
                    in_degrees[item] -= 1

                    if in_degrees[item] == 1:
                        deque.append(item)

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
