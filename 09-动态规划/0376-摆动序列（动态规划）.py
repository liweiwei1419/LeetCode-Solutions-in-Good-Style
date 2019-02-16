class Solution:
    def wiggleMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        size = len(nums)
        if size == 0:
            return 0
        # 从第 2 个元素开始，当前元素比上一个元素大的时候，能够构成的最长摇摆子序列的长度，否则，该值与之前的值相等
        up = [0 for _ in range(size)]
        # 从第 2 个元素开始，当前元素比上一个元素小的时候，能够构成的最长摇摆子序列的长度，否则，该值与之前的值相等
        down = [0 for _ in range(size)]

        up[0] = 1
        down[0] = 1
        for i in range(1, size):
            if nums[i - 1] < nums[i]:
                # 下降
                up[i] = up[i - 1]
                down[i] = up[i - 1] + 1
            elif nums[i - 1] > nums[i]:
                # 上升：表示当前这个元素可以接在 down 所表示的最长摇摆子序列的最后一个，构成一个更长的子序列
                # 此时更新 up 的值，它根据 down 的最后一个 + 1
                # 理解这一步很关键，这一步理解清楚了，其它两个分支就自然清楚了
                up[i] = down[i - 1] + 1
                down[i] = down[i - 1]
            else:
                up[i] = up[i - 1]
                down[i] = down[i - 1]
        return max(up[-1], down[-1])