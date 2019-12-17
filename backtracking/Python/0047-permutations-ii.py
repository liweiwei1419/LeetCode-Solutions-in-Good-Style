from typing import List


class Solution:

    # 要去除重复，可以参考 LeetCode 第 15 题，先排序再去重复

    def permuteUnique(self, nums: List[int]) -> List[List[int]]:

        size = len(nums)
        if size == 0:
            return []
        # 修改 1：首先排序，之后才有可能发现重复分支，升序、降序均可
        nums.sort()
        # nums.sort(reverse=True)

        used = [False] * len(nums)
        res = []
        self.__dfs(nums, 0, size, [], used, res)
        return res

    def __dfs(self, nums, index, size, pre, used, res):
        if index == len(nums):
            res.append(pre.copy())
            return
        for i in range(len(nums)):
            if not used[i]:
                # 修改 2：因为排序以后重复的数一定不会出现在开始，故 i > 0
                if i > 0 and nums[i] == nums[i - 1] and used[i - 1]:
                    # and used[i - 1] 表示，前一个数如果使用过了，剪枝，语义是重复的保留最后一个
                    # and not used[i - 1] 表示，前一个数如果没有使用过，剪枝，语义是重复的保留第 1 个
                    # 这个细小的差别不用特别在意
                    continue
                used[i] = True
                pre.append(nums[i])
                self.__dfs(nums, index + 1, size, pre, used, res)
                used[i] = False
                pre.pop()


if __name__ == '__main__':
    s = Solution()
    nums = [1, 1, 2]
    result = s.permuteUnique(nums)
    print(result)
