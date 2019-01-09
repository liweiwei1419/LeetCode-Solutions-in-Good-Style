# LeetCode 第 47 题：全排列问题 2
# 47. 全排列 II，要求：给定一个可包含重复数字的序列，返回所有不重复的全排列。
# 要去除重复，第 1 件要做的事情就是排序


class Solution:
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if len(nums) == 0:
            return []
        nums.sort()
        used = [False] * len(nums)
        res = []
        self.__dfs(nums, 0, [], used, res)
        return res

    def __dfs(self, nums, index, pre, used, res):
        if index == len(nums):
            res.append(pre.copy())
            return
        for i in range(len(nums)):
            if not used[i]:
                # 如果没有用过
                if i != 0 and nums[i] == nums[i - 1] and not used[i - 1]:
                    continue
                used[i] = True
                pre.append(nums[i])
                self.__dfs(nums, index + 1, pre, used, res)
                used[i] = False
                pre.pop()


if __name__ == '__main__':
    s = Solution()
    nums = [1, 1, 2]
    result = s.permuteUnique(nums)
    print(result)
