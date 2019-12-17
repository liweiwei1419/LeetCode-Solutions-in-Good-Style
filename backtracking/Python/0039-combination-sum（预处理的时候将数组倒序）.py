from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
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
                # 如果预处理的时候将数组倒序，这里就只能用 continue，不能使用 break ，一次去掉一大片
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