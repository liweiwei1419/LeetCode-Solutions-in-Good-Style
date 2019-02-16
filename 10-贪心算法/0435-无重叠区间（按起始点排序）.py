# Definition for an interval.
class Interval:
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e


class Solution:

    # 按照起点排序：选择结尾最早的，后面才有可能接上更多的区间

    def eraseOverlapIntervals(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: int
        """
        size = len(intervals)
        if size <= 1:
            return 0
        intervals.sort(key=lambda x: x.start)
        end = intervals[0].end
        res = 0
        for interval in intervals[1:]:
            if interval.start < end:
                res += 1
                end = min(end, interval.end)
            else:
                end = interval.end
        return res


if __name__ == '__main__':
    intervals = [Interval(1, 2), Interval(1, 2), Interval(1, 2)]
    solution = Solution()
    result = solution.eraseOverlapIntervals(intervals)
    print(result)
