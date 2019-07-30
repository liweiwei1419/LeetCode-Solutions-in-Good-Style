# 时间复杂度O(2n)，空间复杂度 $O(1)$，res 不算额外空间
from typing import List


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        size = len(nums)

        for i in range(size):
            while nums[i] != i + 1:
                if nums[i] != nums[nums[i] - 1]:
                    self.__swap(nums, i, nums[i] - 1)
                else:
                    break

        res = []
        for i in range(size):
            if nums[i] != i + 1:
                res.append(i + 1)
        return res

    def __swap(self, nums, index1, index2):
        nums[index1] = nums[index1] ^ nums[index2]
        nums[index2] = nums[index1] ^ nums[index2]
        nums[index1] = nums[index1] ^ nums[index2]


if __name__ == '__main__':
    solution = Solution()
    nums = [4, 3, 2, 7, 8, 2, 3, 1]
    res = solution.findDisappearedNumbers(nums)
    print(res)
