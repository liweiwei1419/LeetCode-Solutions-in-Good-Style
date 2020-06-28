from typing import List


class Solution:

    def permuteUnique(self, nums: List[int]) -> List[List[int]]:

        size = len(nums)
        res = []
        if size == 0:
            return res
        # 因为含有重复数组，所以先排序
        nums.sort()
        path = [0 for _ in range(size)]
        self.__dfs(nums, 0, 0, path, 0, res)

        return res

    def __dfs(self, nums, index, start, path, state, res):
        if index == len(nums):
            res.append(path[:])
            return

        if index == 0 or nums[index] != nums[index - 1]:
            start = 0

        for i in range(start, len(nums)):
            if (state >> i & 1) == 0:
                # 如果当前的数没有使用过，这一句不好理解
                path[i] = nums[index]
                self.__dfs(nums, index + 1, i + 1, path, state + (1 << i), res)


if __name__ == '__main__':
    s = Solution()
    nums = [1, 1, 2]
    result = s.permuteUnique(nums)
    print(result)
