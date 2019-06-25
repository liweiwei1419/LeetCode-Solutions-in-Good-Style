class Solution:

    # 思路：在回溯的过程中，记录 path 即可

    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        size = len(nums)
        if size == 0:
            return []
        res = []
        self.__dfs(nums, 0, size, [], res)
        return res

    def __dfs(self, nums, start, size, path, res):
        res.append(path[:])
        for i in range(start, size):
            path.append(nums[i])
            # 因为 nums 不包含重复元素，并且每一个元素只能使用一次
            # 所以下一次搜索从 i + 1 开始
            self.__dfs(nums, i + 1, size, path, res)
            path.pop()


if __name__ == '__main__':
    nums = [1, 2, 3]
    solution = Solution()
    result = solution.subsets(nums)
    print(result)
