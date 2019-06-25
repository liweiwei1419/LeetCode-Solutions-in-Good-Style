# 90. 子集 II
# 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
# 说明：解集不能包含重复的子集。


class Solution:
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        size = len(nums)
        if size == 0:
            return []
        nums.sort()
        res = []
        self.__dfs(nums, 0, size, [], res)
        return res

    def __dfs(self, nums, start, size, path, res):
        res.append(path[:])
        for i in range(start, size):
            if i > start and nums[i - 1] == nums[i]:
                continue
            path.append(nums[i])
            self.__dfs(nums, i + 1, size, path, res)
            path.pop()


if __name__ == '__main__':
    nums = [1, 2, 2]
    solution = Solution()
    result = solution.subsetsWithDup(nums)
    print(result)
