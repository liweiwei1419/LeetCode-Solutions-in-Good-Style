from typing import List


class Solution:

    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        size = len(nums)
        if size == 0:
            return []
        nums.sort()
        used = [False] * len(nums)
        res = []
        self.__dfs(nums, 0, size, [], used, res)
        return res

    def __dfs(self, nums, index, size, pre, used, res):
        if index == len(nums):
            res.append(pre)
            return
        for i in range(len(nums)):
            if not used[i]:
                if i > 0 and nums[i] == nums[i - 1] and used[i - 1]:
                    continue
                used[i] = True
                self.__dfs(nums, index + 1, size, pre + [nums[i]], used, res)
                used[i] = False


if __name__ == '__main__':
    s = Solution()
    nums = [1, 1, 2]
    result = s.permuteUnique(nums)
    print(result)
