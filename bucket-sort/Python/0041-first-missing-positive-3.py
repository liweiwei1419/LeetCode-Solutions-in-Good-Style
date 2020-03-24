from typing import List


class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        def swap(nums, index1, index2):
            if index1 == index2:
                return
            nums[index1] = nums[index1] ^ nums[index2]
            nums[index2] = nums[index1] ^ nums[index2]
            nums[index1] = nums[index1] ^ nums[index2]

        for i in range(len(nums)):
            while 1 <= nums[i] <= len(nums) and nums[nums[i] - 1] != nums[i]:
                swap(nums, i, nums[i] - 1)
        for i in range(len(nums)):
            if i + 1 != nums[i]:
                return i + 1
        return len(nums) + 1


if __name__ == '__main__':
    nums = [4, 4, 4, 3, 2, 31, -1, 2]

    solution = Solution()
    res = solution.firstMissingPositive(nums)
    print(res)
