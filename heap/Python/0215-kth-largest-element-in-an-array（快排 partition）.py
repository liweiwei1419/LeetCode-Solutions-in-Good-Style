from typing import List
import random


class Solution:

    def findKthLargest(self, nums: List[int], k: int) -> int:
        def partition(nums, left, right):
            # Return random integer in range [a, b], including both end points.
            random_index = random.randint(left, right)
            nums[random_index], nums[left] = nums[left], nums[random_index]

            pivot = nums[left]
            k = left
            for index in range(left + 1, right + 1):
                if nums[index] < pivot:
                    k += 1
                    nums[k], nums[index] = nums[index], nums[k]
            nums[left], nums[k] = nums[k], nums[left]
            return k

        size = len(nums)
        if size < k:
            raise Exception('程序出错')

        left = 0
        right = len(nums) - 1

        while True:
            index = partition(nums, left, right)
            if index == len(nums) - k:
                return nums[index]
            if index > len(nums) - k:
                right = index - 1
            else:
                left = index + 1


if __name__ == '__main__':
    nums = [3, 7, 8, 1, 2, 4]
    solution = Solution()
    result = solution.findKthLargest(nums, 2)
    print(result)
