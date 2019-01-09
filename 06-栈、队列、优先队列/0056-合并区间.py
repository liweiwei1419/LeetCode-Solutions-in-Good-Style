# 56. 合并区间
# 给出一个区间的集合，请合并所有重叠的区间。

# 考察知识点：排序、数组。

# Definition for an interval.
class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

    def __str__(self):
        return "[{:d},{:d}]".format(self.start, self.end)


class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        l = len(intervals)
        if l < 2:
            return intervals
        # 特别重要的一个步骤别忘了，那就是对区间进行排序
        intervals.sort(key=lambda x: x.start)
        res = []
        res.append(intervals[0])
        for interval in intervals[1:]:
            top = res[-1]
            if interval.start > top.end:
                res.append(interval)
            else:
                top.end = max(top.end, interval.end)
        return res


if __name__ == '__main__':
    interval1 = Interval(1, 3)
    interval2 = Interval(2, 6)
    interval3 = Interval(8, 10)
    interval4 = Interval(15, 18)

    intervals = [interval1, interval2, interval3, interval4]
    solution = Solution()
    result = solution.merge(intervals)
    for item in result:
        print(item)
