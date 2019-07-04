from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        size = len(nums)
        if size == 0:
            return []
        res = []
        for i in range(size + 1):
            self.__dfs(nums, i, 0, [], res)
        return res

    def __dfs(self, nums, depth, begin, path, res):
        # 深度等于 path 长度的时候递归终止
        if len(path) == depth:
            res.append(path[:])
            return

        # 按顺序来的，所以不用设置 used 数组
        for i in range(begin, len(nums)):
            path.append(nums[i])
            print(path)
            self.__dfs(nums, depth, i + 1, path, res)
            path.pop()


if __name__ == '__main__':
    nums = [1, 2, 3]
    solution = Solution()
    result = solution.subsets(nums)
    print(result)
