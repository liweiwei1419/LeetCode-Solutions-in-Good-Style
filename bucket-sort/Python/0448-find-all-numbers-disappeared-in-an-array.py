from typing import List


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # 这里使用了额外空间
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

    # 基于异或运算交换数组两个位置的元素，不使用额外的空间
    def __swap(self, nums, index1, index2):
        # 这一步是必要的，否则会使得一个数变成 0
        if index1 == index2:
            return
        nums[index1] = nums[index1] ^ nums[index2]
        nums[index2] = nums[index1] ^ nums[index2]
        nums[index1] = nums[index1] ^ nums[index2]


if __name__ == '__main__':
    solution = Solution()
    nums = [4, 3, 2, 7, 8, 2, 3, 1]
    res = solution.findDisappearedNumbers(nums)
    print(res)
