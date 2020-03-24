from typing import List


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # 基于异或运算交换数组两个位置的元素，不使用额外的空间
        def swap(nums, index1, index2):
            # 这一步是必要的，否则会使得一个数变成 0
            if index1 == index2:
                return
            nums[index1] = nums[index1] ^ nums[index2]
            nums[index2] = nums[index1] ^ nums[index2]
            nums[index1] = nums[index1] ^ nums[index2]

        for i in range(len(nums)):
            while nums[i] != nums[nums[i] - 1]:
                # 如果不在位置上，并且它将要去的那个位置上的数不等于自己，则交换
                swap(nums, i, nums[i] - 1)

        return [i + 1 for i, num in enumerate(nums) if num != i + 1]


if __name__ == '__main__':
    solution = Solution()
    nums = [4, 3, 2, 7, 8, 2, 3, 1]
    res = solution.findDisappearedNumbers(nums)
    print(res)
