# 40. 组合总和 II
# 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
#
# candidates 中的每个数字在每个组合中只能使用一次。
#
# 说明：
#
# 所有数字（包括目标数）都是正整数。
# 解集不能包含重复的组合。

from typing import List


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        size = len(candidates)
        if size == 0:
            return []
        # 降序
        candidates.sort(reverse=True)
        res = []
        self.__dfs(candidates, size, target, 0, [], res)
        return res

    def __dfs(self, candidates, size, residue, start, path, res):
        if residue == 0:
            res.append(path[:])
            return

        for index in range(start, size):
            # 前面那些很大的数要一个一个看过去
            if candidates[index] > residue:
                continue
            if index > start and candidates[index - 1] == candidates[index]:
                continue
            path.append(candidates[index])
            # 特别注意，不要传入 start + 1 ，而是 index + 1
            self.__dfs(candidates, size, residue - candidates[index], index + 1, path, res)
            path.pop()


if __name__ == '__main__':
    candidates = [10, 1, 2, 7, 6, 1, 5]
    target = 8

    # candidates = [2, 5, 2, 1, 2]
    # target = 5
    solution = Solution()
    result = solution.combinationSum2(candidates, target)
    print(result)
