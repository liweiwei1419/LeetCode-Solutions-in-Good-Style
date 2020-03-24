from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        size = len(nums)
        if size == 0:
            return []

        res = []
        self.__dfs(nums, 0, [], res)
        return res

    def __dfs(self, nums, start, path, res):
        # 区别 1：path 变量不用产生一个副本添加到结果集中国
        res.append(path)
        for i in range(start, len(nums)):
            # 区别 2：每一次状态都是新生成的，因此不用状态重置，即在递归结束以后无需 path.pop()
            self.__dfs(nums, i + 1, path + [nums[i]], res)


if __name__ == '__main__':
    solution = Solution()
    nums = [1, 2, 3]
    res = solution.subsets(nums)
    print(res)
