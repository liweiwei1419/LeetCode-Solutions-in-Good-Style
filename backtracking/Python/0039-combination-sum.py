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
            # 因为全程只有 1 个 path 变量，因此需要把 path 的拷贝加入结果集
            # 否则得到的就是 [[], [], ..., []]
            res.append(path[:])
            # 与上面题解不同，这里必须提前返回，题解是我以前，写的考虑不周
            return

        for index in range(begin, size):
            residue = target - candidates[index]
            if residue < 0:
                break

            path.append(candidates[index])
            # 在递归方法前后，对 path 变量的操作是对称的
            self.__dfs(candidates, index, size, path, res, residue)
            # 状态变量 `path` 发生重置
            path.pop()
