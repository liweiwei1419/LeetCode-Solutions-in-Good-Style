from typing import List


class Solution:

    # 暴力解法：中心扩散，找到两边最高的那个高度，还要减去自己的高度

    def trap(self, height: List[int]) -> int:
        size = len(height)
        if size < 3:
            return 0
        res = 0
        # 注意两边都不能存水
        for i in range(1, size - 1):
            left_max = self.__left_max(height, i)
            right_max = self.__right_max(height, i, size)

            if height[i] < min(left_max, right_max):
                res += min(left_max, right_max) - height[i]
        return res

    def __left_max(self, height, center):
        i = center - 1
        res = 0
        while i >= 0:
            res = max(res, height[i])
            i -= 1
        return res

    def __right_max(self, height, center, size):
        res = 0
        for i in range(center + 1, size):
            res = max(res, height[i])
        return res
