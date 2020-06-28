from typing import List


class Solution:

    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        size = len(nums)
        res = []
        if size == 0:
            return res
        # 因为含有重复数组，所以先排序
        nums.sort()
        marked = [False for _ in range(size)]
        path = [0 for _ in range(size)]
        self.__dfs(nums, 0, 0, path, marked, res)
        return res

    def __dfs(self, nums, index, start, path, marked, res):
        if index == len(nums):
            res.append(path[:])
            return
        for i in range(start, len(nums)):
            if not marked[i]:
                marked[i] = True
                # 这一句不好理解
                path[i] = nums[index]
                if index + 1 < len(nums) and nums[index] != nums[index + 1]:
                    self.__dfs(nums, index + 1, 0, path, marked, res)
                else:
                    self.__dfs(nums, index + 1, i + 1, path, marked, res)
                marked[i] = False


if __name__ == '__main__':
    s = Solution()
    nums = [1, 1, 2]
    result = s.permuteUnique(nums)
    print(result)
