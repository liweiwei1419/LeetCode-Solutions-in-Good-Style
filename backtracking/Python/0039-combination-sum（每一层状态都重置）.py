from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        size = len(candidates)
        if size == 0:
            return []

        candidates.sort()
        path = []
        res = []
        self.__dfs(candidates, 0, size, path, res, target)
        return res

    def __dfs(self, candidates, begin, size, path, res, target):
        if target == 0:
            # 因为每一次的状态变量都是新生成的，直接把它加到结果集中去就好了
            res.append(path)
            return

        for index in range(begin, size):
            residue = target - candidates[index]
            if residue < 0:
                break

            # path + [candidates[index]] 会生成一个新的列表，传递到下一层
            self.__dfs(candidates, index, size, path + [candidates[index]], res, residue)
