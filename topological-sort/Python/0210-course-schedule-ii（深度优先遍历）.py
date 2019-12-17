from typing import List


class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        """
        :type numCourses: int 课程门数
        :type prerequisites: List[List[int]] 课程与课程之间的关系
        :rtype: bool
        """
        # 课程的长度
        clen = len(prerequisites)
        if clen == 0:
            # 没有课程，当然可以完成课程的学习
            return [i for i in range(numCourses)]

        # 逆邻接表
        inverse_adj = [set() for _ in range(numCourses)]
        # 想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
        # 1 -> 0，这里要注意：不要弄反了
        for second, first in prerequisites:
            inverse_adj[second].add(first)

        visited = [0 for _ in range(numCourses)]
        # print("in_degrees", in_degrees)
        # 首先遍历一遍，把所有入度为 0 的结点加入队列

        res = []
        for i in range(numCourses):
            if self.__dfs(i, inverse_adj, visited, res):
                return []
        return res

    def __dfs(self, vertex, inverse_adj, visited, res):
        """
        注意：这个递归方法的返回值是返回是否有环
        :param vertex: 结点的索引
        :param inverse_adj: 逆邻接表，记录的是当前结点的前驱结点的集合
        :param visited: 记录了结点是否被访问过，2 表示当前正在 DFS 这个结点
        :return: 是否有环
        """
        # 2 表示这个结点正在访问
        if visited[vertex] == 2:
            # DFS 的时候如果遇到一样的结点，就表示图中有环，课程任务便不能完成
            return True
        if visited[vertex] == 1:
            return False
        # 表示正在访问这个结点
        visited[vertex] = 2
        # 递归访问前驱结点
        for precursor in inverse_adj[vertex]:
            # 如果没有环，就返回 False，
            # 执行以后，逆拓扑序列就存在 res 中
            if self.__dfs(precursor, inverse_adj, visited, res):
                return True

        # 能走到这里，说明所有的前驱结点都访问完了，所以可以输出了
        # 并且将这个结点状态置为 1
        visited[vertex] = 1

        # 先把 vertex 这个结点的所有前驱结点都输出之后，再输出自己
        res.append(vertex)
        # 最后不要忘记返回 False 表示无环
        return False


if __name__ == '__main__':
    numCourses = 2
    prerequisites = [[0, 1]]
    solution = Solution()
    result = solution.findOrder(numCourses, prerequisites)
    print(result)
