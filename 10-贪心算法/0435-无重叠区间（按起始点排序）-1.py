# Definition for an interval.
class Interval:
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e


class Solution:

    # 按照起点排序：选择结尾最早的，后面才有可能接上更多的区间
    # 那么要删除的就是：与之前的区间有重叠的，并且结尾还比当前结尾长的
    # 关键：如果两个区间有重叠，应该保留那个结尾短的

    def eraseOverlapIntervals(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: int
        """
        # 特判
        size = len(intervals)
        if size <= 1:
            return 0
        intervals.sort(key=lambda x: x.start)
        # 表示去掉的区间数
        res = 0
        end = intervals[0].end

        for interval in intervals[1:]:
            # 根据题目意思，严格小，才算重叠
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
