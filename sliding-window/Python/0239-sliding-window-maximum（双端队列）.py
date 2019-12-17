from typing import List


class Solution:

    # 这里双端队列，正好是一个单调队列
    # 保持性质：单调递减（不增）队列

    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        size = len(nums)
        if size == 0:
            return []
        window = []
        res = []
        for i in range(size):
            if i >= k and window[0] == i - k:
                window.pop(0)
            while window and nums[window[-1]] <= nums[i]:
                window.pop()
            window.append(i)
            if i >= k - 1:
                res.append(nums[window[0]])
        return res
