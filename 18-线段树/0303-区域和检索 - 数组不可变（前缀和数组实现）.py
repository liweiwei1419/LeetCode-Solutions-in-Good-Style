class NumArray:

    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        self.size = len(nums)

        if self.size > 0:
            self.cumsum = [0 for _ in range(self.size + 1)]
            self.cumsum[1] = nums[0]
            for i in range(2, len(nums) + 1):
                self.cumsum[i] = self.cumsum[i - 1] + nums[i - 1]

    def sumRange(self, i, j):
        """
        :type i: int
        :type j: int
        :rtype: int
        """
        if self.size > 0:
            return self.cumsum[i] - self.cumsum[i - 1]
        return 0

# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(i,j)
