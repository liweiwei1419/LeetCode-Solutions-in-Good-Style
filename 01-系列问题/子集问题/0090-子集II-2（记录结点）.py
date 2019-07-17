from typing import List


class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        size = len(nums)
        if size == 0:
            return []
        # 关键 1：排序是为了后面剪枝去重
        nums.sort()
        path = []
        res = []
        self.__dfs(nums, 0, size, path, res)
        return res

    def __dfs(self, nums, start, size, path, res):
        # 关键 3：记录每个结点的路径
        res.append(path[:])
        for index in range(start, size):
            # 关键 2：剪枝的常见操作
            if index > start and nums[index - 1] == nums[index]:
                continue
            path.append(nums[index])
            self.__dfs(nums, index + 1, size, path, res)
            path.pop()


if __name__ == '__main__':
    nums = [1, 2, 2]
    solution = Solution()
    result = solution.subsetsWithDup(nums)
    print(result)
