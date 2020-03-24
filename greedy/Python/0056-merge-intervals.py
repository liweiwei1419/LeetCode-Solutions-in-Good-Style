from typing import List


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        size = len(intervals)
        if size < 2:
            return intervals
        # 特别重要的一个步骤别忘了，那就是对区间进行排序
        intervals.sort(key=lambda x: x[0])
        res = [intervals[0]]
        for i in range(1, size):
            top = res[-1]
            if intervals[i][0] > top[1]:
                res.append(intervals[i])
            else:
                top[1] = max(top[1], intervals[i][1])
        return res


if __name__ == '__main__':
    intervals = [[1, 3], [2, 6], [8, 10], [15, 18]]
    solution = Solution()
    result = solution.merge(intervals)
    for item in result:
        print(item)
