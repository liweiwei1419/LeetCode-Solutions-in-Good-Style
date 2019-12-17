from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        size = len(candidates)
        if size == 0:
            return []
        candidates.sort()
        res = []
        self.__dfs(candidates, 0, size, target, [], res)
        return res

    def __dfs(self, candidates, start, size, residue, path, res):
        if residue == 0:
            res.append(path)
            return

        for index in range(start, size):
            if residue - candidates[index] < 0:
                break
            self.__dfs(candidates, index, size, residue - candidates[index], path + [candidates[index]], res)
