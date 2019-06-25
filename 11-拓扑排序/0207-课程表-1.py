# 207. 课程表
# 现在你总共有 n 门课需要选，记为 0 到 n-1。
# 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
# 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
class Solution(object):

    # 思想：该方法的每一步总是输出当前无前趋（即入度为零）的结点

    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        """
        :type numCourses: int 课程门数
        :type prerequisites: List[List[int]] 课程与课程之间的关系
        :rtype: bool
        """
        # 特判
        if numCourses == 0:
            return False
        clen = len(prerequisites)
        if clen == 0:
            # 没有课程，当然可以完成课程的学习
            return True

        # 步骤1：构建邻接表、统计每个顶点的入度

        # 邻接表，使用散列表是为了去重
        adj = [set() for _ in range(numCourses)]
        # 入度数组，记录了指向它的结点的个数
        in_degrees = [0 for _ in range(numCourses)]

        # 想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
        # [0,1] 表示 1 在先，0 在后

        # 注意：邻接表存放的是后继 successor 结点的集合
        for second, first in prerequisites:
            in_degrees[second] += 1
            adj[first].add(second)

        for i in range(numCourses):
            j = 0
            while j < numCourses and in_degrees[j] != 0:
                j += 1
            # 在遍历的过程中，没有找到入度为 0 的结点，说明存在环，课程学习任务就无法完成
            if j == numCourses:
                return False
            # 找到了一个入度为 0 的结点
            # 1、将它删除，即设置为 -1
            # 2、将它指向的结点的入度全部减一
            in_degrees[j] -= 1
            for successor in adj[j]:
                in_degrees[successor] -= 1
        return True


if __name__ == '__main__':
    numCourses = 2
    prerequisites = [[0, 1]]
    solution = Solution()
    result = solution.canFinish(numCourses, prerequisites)
    print(result)
