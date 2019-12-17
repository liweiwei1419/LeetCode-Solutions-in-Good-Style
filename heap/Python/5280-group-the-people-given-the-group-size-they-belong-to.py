from typing import List
import heapq


class Solution:
    def groupThePeople(self, groupSizes: List[int]) -> List[List[int]]:
        size = len(groupSizes)

        res = []

        # 特判
        if size == 0:
            return res

        # Python 的 heapq 的用法：https://docs.python.org/3.8/library/heapq.html
        h = []

        for i in range(size):
            # 传入的是 tuple
            heapq.heappush(h, (groupSizes[i], i))

        # 单独的 h 放在 while 里面，表示 h 非空的时候，才执行 while 循环体
        while h:
            # h 是被 heapq 模块维护的列表结构，是堆有序的
            cur_size = h[0][0]

            cur_res = []
            for _ in range(cur_size):
                cur_res.append(heapq.heappop(h)[1])

            res.append(cur_res)
        return res


if __name__ == '__main__':
    groupSizes = [3, 3, 3, 3, 3, 1, 3]
    solution = Solution()

    res = solution.groupThePeople(groupSizes)
    print(res)
