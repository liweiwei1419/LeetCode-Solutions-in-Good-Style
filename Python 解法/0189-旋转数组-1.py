class Solution:
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: void Do not return anything, modify nums in-place instead.
        """

        length = len(nums)
        if length < 2 or k <= 0:
            return

        self.reverse(nums, 0, length - 1)
        k = k % length
        self.reverse(nums, 0, k - 1)
        self.reverse(nums, k, length - 1)

    def reverse(self, nums, begin, end):
        left = begin
        right = end

        while left < right:
            self._swap(nums, left, right)
            left += 1
            right -= 1

    def _swap(self, nums, index1, index2):
        if index1 == index2:
            return
        temp = nums[index1]
        nums[index1] = nums[index2]
        nums[index2] = temp


if __name__ == '__main__':
    s = Solution()
    nums = [1, 2, 3, 4, 5, 6, 7]
    k = 3
    s.rotate(nums, k)
    print(nums)
