from typing import List


class Solution:
    # 生成邻接表和入度关系，图结构更清楚

    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        plen = len(prerequisites)
        if plen == 0:
            # 没有课程，当然可以完成课程的学习
            return True
        depend = {}  # {0: [1], 1: []} 生成邻接表: 0后面连着1,1后面没有元素
        degree = dict((i, 0) for i in range(numCourses))  # 字典推导式 {0: 0, 1: 1}    0的入度为0,1的入度为1

        print(degree)


        for i in range(plen):
            depend.setdefault(prerequisites[i][1], []).append(prerequisites[i][0])  # 邻接表生成
            degree[prerequisites[i][0]] += 1  # 入度统计
        for i in range(numCourses):
            depend.setdefault(i, [])  # 比如2, [[1,0]]    1的后面没有节点,但是上面一个for循环没有处理到,意思是没有使得{1:[]},所以我们需要手动添加

        # print(depend,degree) #打印这一句,你将能更清楚看见点与点之间的依赖关系
        queue = [u for u in degree if degree[u] == 0]
        count = 0
        while queue:
            tmp = queue.pop(0)
            count += 1

            for i in depend[tmp]:
                degree[i] -= 1
                if degree[i] == 0:
                    queue.append(i)
        if count != numCourses:
            return False
        return True


if __name__ == '__main__':
    numCourses = 2
    prerequisites = [[1,0],[0,1]]


    print(len(prerequisites))
    solution = Solution()
    result = solution.canFinish(numCourses, prerequisites)
    print(result)
