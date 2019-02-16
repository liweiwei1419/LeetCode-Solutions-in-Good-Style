# 39. 组合总和
# 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
#
# candidates 中的数字可以无限制重复被选取。
#
# 说明：
#
# 所有数字（包括 target）都是正整数。
# 解集不能包含重复的组合。


class Solution:
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """

        if len(candidates) == 0:
            return []
        candidates.sort(reverse=True)
        res = []
        self.__dfs(candidates, 0, target, [], res)
        return res

    def __dfs(self, candidates, start, residue, path, res):
        # 先写递归终止条件
        if residue == 0:
            res.append(path[:])
            return

        for index in range(start, len(candidates)):
            if residue - candidates[index] < 0:
                continue

            path.append(candidates[index])
            self.__dfs(candidates, index, residue - candidates[index], path, res)
            path.pop()


if __name__ == '__main__':
    candidates = [2, 3, 6, 7]
    target = 7

    solution = Solution()
    result = solution.combinationSum(candidates, target)
    print(result)
