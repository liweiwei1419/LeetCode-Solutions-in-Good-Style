# 40. 组合总和 II
# 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
#
# candidates 中的每个数字在每个组合中只能使用一次。
#
# 说明：
#
# 所有数字（包括目标数）都是正整数。
# 解集不能包含重复的组合。
class Solution:
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """

        if len(candidates) == 0:
            return []
        candidates.sort()
        print(candidates)
        res = []
        self.__dfs(candidates, target, 0, [], res)
        return res

    def __dfs(self, candidates, residue, start, path, res):
        if residue == 0:
            res.append(path[:])
            return

        for i in range(start, len(candidates)):
            if residue < candidates[i]:
                break
            if i > start and candidates[i - 1] == candidates[i]:
                continue
            path.append(candidates[i])
            # 特别注意，不要传入 start + 1 ，而是 i + 1
            self.__dfs(candidates, residue - candidates[i], i + 1, path, res)
            path.pop()


if __name__ == '__main__':
    candidates = [10, 1, 2, 7, 6, 1, 5]
    target = 8

    # candidates = [2, 5, 2, 1, 2]
    # target = 5
    solution = Solution()
    result = solution.combinationSum2(candidates, target)
    print(result)
