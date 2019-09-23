from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        :type nums: List[int]
        :type k: int
        :rtype: void Do not return anything, modify nums in-place instead.
        """

        size = len(nums)
        if size < 2 or k <= 0:
            return

        self.__reverse(nums, 0, size - 1)
        k = k % size
        self.__reverse(nums, 0, k - 1)
        self.__reverse(nums, k, size - 1)

    def __reverse(self, nums, begin, end):
        left = begin
        right = end

        while left < right:
            self.__swap(nums, left, right)
            left += 1
            right -= 1

    def __swap(self, nums, index1, index2):
        temp = nums[index1]
        nums[index1] = nums[index2]
        nums[index2] = temp


if __name__ == '__main__':
    s = Solution()
    nums = [1, 2, 3, 4, 5, 6, 7]
    k = 3
    s.rotate(nums, k)
    print(nums)
