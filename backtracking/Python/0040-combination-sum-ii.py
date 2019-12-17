from typing import List


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        def backtracking(path, target, start=0):
            if target == 0:
                res.append(path)
                return
            for i in range(start, size):
                if i > start and candidates[i] == candidates[i - 1]:
                    continue
                if target - candidates[i] < 0:
                    break
                backtracking(path + [candidates[i]], target - candidates[i], i + 1)

        res = []
        candidates.sort()
        size = len(candidates)
        backtracking([], target)
        return res


if __name__ == '__main__':
    candidates = [10, 1, 2, 7, 6, 1, 5]
    target = 8
    solution = Solution()
    result = solution.combinationSum2(candidates, target)
    print(result)
