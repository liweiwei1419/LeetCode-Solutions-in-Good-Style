# Definition for an interval.
class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

    def __str__(self):
        return '[' + str(self.start) + ',' + str(self.end) + ']'


class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        result = []
        # 按照开始端点升序排序
        sorted_intervals = sorted(intervals, key=lambda x: x.start)

        for intv in sorted_intervals:
            if len(result) != 0 and result[-1].end >= intv.start:
                # 说明当前遍历到的区间和结果集中有交集
                result[-1].end = max(result[-1].end, intv.end)
            else:
                result.append(intv)
        return result


if __name__ == '__main__':
    # [[1, 3], [2, 6], [8, 10], [15, 18]]
    i1 = Interval(1, 3)
    i2 = Interval(2, 6)
    i3 = Interval(8, 10)
    i4 = Interval(15, 18)
    intervals = [i1, i2, i3, i4]
    solution = Solution()
    result = solution.merge(intervals)
    for item in result:
        print(item)
