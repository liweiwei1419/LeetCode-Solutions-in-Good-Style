from typing import List


class Solution:

    # 贪心算法：按照终点排序

    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        size = len(intervals)
        if size <= 1:
            return 0
        intervals.sort(key=lambda x: x[1])
        end = intervals[0][1]
        res = 1
        for i in range(1, size):
            if intervals[i][0] >= end:
                res += 1
                end = intervals[i][1]
        return size - res


if __name__ == '__main__':
    intervals = [(1, 2), (1, 2), (1, 2)]
    solution = Solution()
    result = solution.eraseOverlapIntervals(intervals)
    print(result)
