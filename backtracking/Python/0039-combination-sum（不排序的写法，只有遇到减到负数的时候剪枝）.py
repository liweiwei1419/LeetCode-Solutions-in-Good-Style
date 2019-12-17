from typing import List


class Solution:

    # 不排序的写法，只有遇到减到负数的时候剪枝

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        size = len(candidates)
        if size == 0:
            return []

        res = []
        self.__dfs(candidates, size, 0, [], target, res)
        return res

    def __dfs(self, candidates, size, start, path, residue, res):
        # 递归加深了一层
        if residue < 0:
            return
        if residue == 0:
            res.append(path[:])
            return

        for index in range(start, size):
            path.append(candidates[index])
            # 注意：因为数字可以无限制重复被选取，因此起始位置还是自己
            self.__dfs(candidates, size, index, path, residue - candidates[index], res)
            path.pop()


if __name__ == '__main__':
    candidates = [2, 3, 6, 7]
    target = 7
    solution = Solution()
    result = solution.combinationSum(candidates, target)
    print(result)
