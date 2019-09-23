from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        size = len(nums)
        if size == 0:
            return []

        state = 0
        res = []
        self.__dfs(nums, 0, size, [], state, res)
        return res

    def __dfs(self, nums, index, size, path, state, res):
        # 先写递归终止条件
        if index == size:
            res.append(path)
            return

        for i in range(size):
            if ((state >> i) & 1) == 0:
                self.__dfs(nums, index + 1, size, path + [nums[i]], state ^ (1 << i), res)
