from typing import List


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        def dfs(path, target, begin):
            if target == 0:
                res.append(path)
                return
            for i in range(begin, size):
                if i > begin and candidates[i] == candidates[i - 1]:
                    continue
                if target - candidates[i] < 0:
                    break
                dfs(path + [candidates[i]], target - candidates[i], i + 1)

        size = len(candidates)
        if size == 0:
            return []

        res = []
        candidates.sort()
        size = len(candidates)
        dfs([], target, 0)
        return res


if __name__ == '__main__':
    candidates = [10, 1, 2, 7, 6, 1, 5]
    target = 8
    solution = Solution()
    res = solution.combinationSum2(candidates, target)
    print(res)
