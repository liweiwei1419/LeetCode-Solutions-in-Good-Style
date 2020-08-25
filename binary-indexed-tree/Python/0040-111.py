from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates = sorted(candidates)

        ans = []

        def dfs(trace, target):
            if target == 0:
                ans.append(trace)
            for i in range(len(candidates)):
                resi = target - candidates[i]
                if resi >= 0:
                    # 在这里就是剪枝
                    # if not trace or trace[-1] <= candidates[i]:
                    dfs(trace + [candidates[i]], resi)
                else:
                    break

        dfs([], target)
        return ans


if __name__ == '__main__':
    marked = [[False for _ in range(5)]] * 5
    marked[0][0] = True

    for i in range(5):
        print(marked[i])
