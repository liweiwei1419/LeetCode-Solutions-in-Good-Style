from typing import List


class NumArray:

    def __init__(self, nums: List[int]):

        """
        :type nums: List[int]
        """
        self.size = len(nums)
        if self.size == 0:
            return

        self.pre_sum = [0 for _ in range(self.size + 1)]
        self.pre_sum[0] = 0
        for i in range(self.size):
            self.pre_sum[i + 1] = self.pre_sum[i] + nums[i]

    def sumRange(self, i: int, j: int) -> int:
        if self.size > 0:
            return self.pre_sum[j + 1] - self.pre_sum[i]
        return 0

# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(i,j)
