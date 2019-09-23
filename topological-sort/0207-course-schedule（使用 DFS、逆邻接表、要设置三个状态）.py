from typing import List


class Solution:

    # 这里使用逆邻接表

    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        """
        :type numCourses: int 课程门数
        :type prerequisites: List[List[int]] 课程与课程之间的关系
        :rtype: bool
        """
        # 课程的长度
        clen = len(prerequisites)
        if clen == 0:
            # 没有课程，当然可以完成课程的学习
            return True
        # 深度优先遍历，判断结点是否访问过
        # 这里要设置 3 个状态
        # 0 就对应 False ，表示结点没有访问过
        # 1 就对应 True ，表示结点已经访问过，在深度优先遍历结束以后才置为 1
        # 2 表示当前正在遍历的结点，如果在深度优先遍历的过程中，
        # 有遇到状态为 2 的结点，就表示这个图中存在环
        visited = [0 for _ in range(numCourses)]

        # 逆邻接表，存的是每个结点的前驱结点的集合
        # 想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
        # 1 在前，0 在后
        inverse_adj = [set() for _ in range(numCourses)]
        for second, first in prerequisites:
            inverse_adj[second].add(first)

        for i in range(numCourses):
            # 在遍历的过程中，如果发现有环，就退出
            if self.__dfs(i, inverse_adj, visited):
                return False
        return True

    def __dfs(self, vertex, inverse_adj, visited):
        """
        注意：这个递归方法的返回值是返回是否有环
        :param vertex: 结点的索引
        :param inverse_adj: 逆邻接表，记录的是当前结点的前驱结点的集合
        :param visited: 记录了结点是否被访问过，2 表示当前正在 DFS 这个结点
        :return: 是否有环，返回 True 表示这个有向图有环
        """
        # 2 表示这个结点正在访问
        if visited[vertex] == 2:
            # 表示遇到环
            return True
        if visited[vertex] == 1:
            return False

        visited[vertex] = 2
        for precursor in inverse_adj[vertex]:
            # 如果有环，就返回 True 表示有环
            if self.__dfs(precursor, inverse_adj, visited):
                return True

        # 1 表示访问结束
        # 先把 vertex 这个结点的所有前驱结点都输出之后，再输出自己
        visited[vertex] = 1
        return False


if __name__ == '__main__':
    numCourses = 4
    prerequisites = [[1, 0], [2, 0], [3, 1], [3, 2]]
    solution = Solution()
    result = solution.canFinish(numCourses, prerequisites)
    print(result)

    # precursor 前驱
    # successor 后继
