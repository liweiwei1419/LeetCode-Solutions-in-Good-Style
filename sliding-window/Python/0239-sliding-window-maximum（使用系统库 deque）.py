from typing import List
from collections import deque


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        size = len(nums)

        # 特判
        if size == 0:
            return []
        # 结果集
        res = []
        # 滑动窗口，注意：保存的是索引值
        window = deque()

        for i in range(size):
            # 当元素从左边界滑出的时候，如果它恰恰好是滑动窗口的最大值
            # 那么将它弹出
            if i >= k and i - k == window[0]:
                window.popleft()

            # 如果滑动窗口非空，新进来的数比队列里已经存在的数还要大
            # 则说明已经存在数一定不会是滑动窗口的最大值（它们毫无出头之日）
            # 将它们弹出
            while window and nums[window[-1]] <= nums[i]:
                window.pop()
            window.append(i)

            # 队首一定是滑动窗口的最大值的索引
            if i >= k - 1:
                res.append(nums[window[0]])
        return res