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

    def __dfs(self, nums, index, size, pre, state, res):
        # 先写递归终止条件
        if index == size:
            res.append(pre.copy())
            return

        for i in range(size):
            if ((state >> i) & 1) == 0:
                # 如果没有用过，就用它
                state ^= (1 << i)
                pre.append(nums[i])

                # 在 dfs 前后，代码是对称的
                self.__dfs(nums, index + 1, size, pre, state, res)

                # 状态重置
                state ^= (1 << i)
                pre.pop()
