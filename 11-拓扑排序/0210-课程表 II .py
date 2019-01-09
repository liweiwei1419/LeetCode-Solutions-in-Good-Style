# 210. 课程表 II
# 现在你总共有 n 门课需要选，记为 0 到 n-1。
# 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
# 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
# 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。

class Solution(object):
    def findOrder(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]
        """
        clen = len(prerequisites)
        if clen == 0:
            return [i for i in range(numCourses)]
        in_degrees = [0] * numCourses
        graph = [[] for _ in range(numCourses)]
        for pre in prerequisites:
            in_degrees[pre[0]] += 1
            graph[pre[1]].append(pre[0])

        res = []
        queue = []
        for index, in_degree in enumerate(in_degrees):
            if in_degree == 0:
                queue.append(index)
        while queue:
            first = queue.pop(0)
            res.append(first)
            for neighbor in graph[first]:
                in_degrees[neighbor] -= 1
                if in_degrees[neighbor] == 0:
                    queue.append(neighbor)
        if len(res) != numCourses:
            return []
        return res


if __name__ == '__main__':
    numCourses = 4
    prerequisites = [[1, 0], [2, 0], [3, 1], [3, 2]]
    solution = Solution()
    result = solution.findOrder(numCourses, prerequisites)
    print(result)
