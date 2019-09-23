from typing import List


class Solution:

    # 按照起点排序：选择结尾最早的，后面才有可能接上更多的区间
    # 那么要删除的就是：与之前的区间有重叠的，并且结尾还比当前结尾长的
    # 关键：如果两个区间有重叠，应该保留那个结尾短的

    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        size = len(intervals)
        if size <= 1:
            return 0
        intervals.sort(key=lambda x: x[0])
        end = intervals[0][1]
        res = 0
        for i in range(1, size):
            if intervals[i][0] < end:
                res += 1
                end = min(end, intervals[i][1])
            else:
                end = intervals[i][1]
        return res


if __name__ == '__main__':
    intervals = [[1, 2], [1, 2], [1, 2]]
    solution = Solution()
    result = solution.eraseOverlapIntervals(intervals)
    print(result)
