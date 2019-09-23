from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        size = len(nums)
        if len(nums) == 0:
            return []

        used = [False] * size
        res = []
        self.__dfs(nums, 0, size, [], used, res)
        return res

    def __dfs(self, nums, index, size, pre, used, res):
        """
        :param nums:
        :param index: 表示已经选择了几个数
        :param size:
        :param pre:
        :param used:
        :param res:
        :return:
        """
        # 先写递归终止条件
        if index == size:
            res.append(pre.copy())
            return

        for i in range(size):
            if not used[i]:
                # 如果没有用过，就用它
                used[i] = True
                pre.append(nums[i])

                # 在 dfs 前后，代码是对称的
                self.__dfs(nums, index + 1, size, pre, used, res)

                used[i] = False
                pre.pop()
