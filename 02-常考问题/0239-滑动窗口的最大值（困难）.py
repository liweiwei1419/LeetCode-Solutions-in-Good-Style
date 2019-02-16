# 239. Sliding Window Maximum
# 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
# 返回滑动窗口最大值。
# 有看到滑动窗口的问题，一般来说，会是一个高频问题


class Solution:
    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        size = len(nums)
        if size == 0:
            return []

        # 用双端队列的思想解决这个问题，这个 Window 保存的是索引
        window = []
        res = []

        for i in range(size):
            if i >= k and window[0] <= i - k:
                # 只要是出了滑动窗口的部分，并且左边的索引不能用
                # window 存的是索引
                # 特别注意：只有这种情况，才去掉 window 的第 1 个
                window.pop(0)
            while window and nums[window[-1]] <= nums[i]:
                # 这一行代码去掉 window 的最后一个元素
                window.pop()

            window.append(i)
            if i >= k - 1:
                res.append(nums[window[0]])
        return res
