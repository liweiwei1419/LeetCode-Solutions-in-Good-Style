# 207. 课程表
# 现在你总共有 n 门课需要选，记为 0 到 n-1。
# 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
# 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
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
        # 入度数组，一开始全部为 0
        in_degrees = [0] * numCourses
        # 邻接表
        graph = [[] for _ in range(numCourses)]
        # 想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
        # 1 -> 0，这里要注意：不要弄反了
        for pre in prerequisites:
            in_degrees[pre[0]] += 1
            graph[pre[1]].append(pre[0])

        # print("in_degrees", in_degrees)
        # 首先遍历一遍，把所有入度为 0 的结点加入队列
        res = []
        queue = []
        for index, in_degree in enumerate(in_degrees):
            if in_degree == 0:
                queue.append(index)
        # print('queue', queue)
        while queue:
            first = queue.pop(0)
            # print('first', first)
            res.append(first)

            for neighbor in graph[first]:
                in_degrees[neighbor] -= 1
                if in_degrees[neighbor] == 0:
                    queue.append(neighbor)

        # print(res)
        return len(res) == numCourses


if __name__ == '__main__':
    numCourses = 2
    prerequisites = [[0, 1]]
    solution = Solution()
    result = solution.canFinish(numCourses, prerequisites)
    print(result)
