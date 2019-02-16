class Solution:

    def __init__(self):
        self.res = 0

    def findTargetSumWays(self, nums, S):
        """
        :type nums: List[int]
        :type S: int
        :rtype: int
        """
        size = len(nums)

        self.__dfs(nums, size, 0, 0, S)
        return self.res

    def __dfs(self, nums, size, start, cur_sum, S):
        if start == size:
            # 到尾巴了，看看累积和是不是达到 S 了
            if cur_sum == S:
                self.res += 1
                return
        else:
            self.__dfs(nums, size, start + 1, cur_sum + nums[start], S)
            self.__dfs(nums, size, start + 1, cur_sum - nums[start], S)


if __name__ == '__main__':
    solution = Solution()
    nums = [35, 25, 24, 23, 2, 47, 39, 22, 3, 7, 11, 26, 6, 30, 5, 34, 10, 43, 41, 28]
    S = 49
    result = solution.findTargetSumWays(nums, S)
    print(result)
