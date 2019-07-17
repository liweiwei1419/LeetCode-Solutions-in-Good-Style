# 90. 子集 II
# 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
# 说明：解集不能包含重复的子集。

from typing import List

# 不推荐这个方法，在两个 for 循环中完成搜索

class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        size = len(nums)
        if size == 0:
            return []
        nums.sort()
        res = []

        def dfs(max_count, begin, path):
            if max_count == len(path):
                res.append(path.copy())
                return
            for i in range(begin, len(nums)):
                # 注意：这里不要写成 i > 0
                if i > begin and nums[i - 1] == nums[i]:
                    continue
                path.append(nums[i])
                dfs(max_count, i + 1, path)
                path.pop()

        for max_count in range(0, size + 1):
            dfs(max_count, 0, [])
        return res


if __name__ == '__main__':
    nums = [1, 2, 2]
    solution = Solution()
    result = solution.subsetsWithDup(nums)
    print(result)
