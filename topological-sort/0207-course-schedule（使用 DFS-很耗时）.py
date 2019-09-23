from typing import List

class Solution:

    # 说明：这个 DFS 有点傻，把每个结点都"一条道走到底"，没有重复，才敢说可以拓扑排序
    # 这里建立的邻接表是后继邻接表
    # 改进方法，使用前驱邻接表

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
        visited = [False for _ in range(numCourses)]
        # 邻接表

        # 想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
        # [0,1] 表示 1 在先，0 在后
        adj = [set() for _ in range(numCourses)]
        for pre in prerequisites:
            adj[pre[1]].add(pre[0])

        # 思路：每个点都递归到底，看看是否形成环
        for i in range(numCourses):
            if not self.__dfs(i, adj, visited):
                return False
        return True

    def __dfs(self, vertex, adj, visited):
        # 如果访问过，就表示形成环，则课程不能完成
        if visited[vertex]:
            return False
        else:
            visited[vertex] = True

        # 把后继结点递归访问一次，如果返回 True ，则表示没有环
        for successor in adj[vertex]:
            if not self.__dfs(successor, adj, visited):
                return False
        # 状态重置
        visited[vertex] = False
        return True


if __name__ == '__main__':
    numCourses = 2
    prerequisites = [[0, 1], [1, 0]]
    solution = Solution()
    result = solution.canFinish(numCourses, prerequisites)
    print(result)

    # precursor 前驱
    # successor 后继
