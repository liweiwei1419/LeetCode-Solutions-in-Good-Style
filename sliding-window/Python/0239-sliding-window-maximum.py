from typing import List


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        size = len(nums)

        # 特判
        if size == 0:
            return []
        # 结果集
        res = []
        # 用双端队列的思想解决这个问题，这个 Window 保存的是索引
        window = []

        for i in range(size):
            # 当元素从左边界滑出的时候，如果它恰恰好是滑动窗口的最大值
            # 那么将它弹出
            if i >= k and i - k == window[0]:
                # 只要是出了滑动窗口的部分，并且左边的索引不能用
                # window 存的是索引
                # 特别注意：只有这种情况，才去掉 window 的第 1 个
                window.pop(0)

            # 如果滑动窗口非空，新进来的数比队列里已经存在的数还要大
            # 则说明已经存在数一定不会是滑动窗口的最大值（它们毫无出头之日）
            # 将它们弹出
            while window and nums[window[-1]] <= nums[i]:
                # 这一行代码去掉 window 的最后一个元素
                window.pop()
            window.append(i)

            # 队首一定是滑动窗口的最大值的索引
            if i >= k - 1:
                res.append(nums[window[0]])
        return res
