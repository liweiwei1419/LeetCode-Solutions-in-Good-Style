from typing import List


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:

        res = []
        cands = sorted(candidates)

        n = len(candidates)

        def DFS(begin, remain, path):
            if remain == 0:
                res.append(path[:])
                return

            if remain < 0:
                return

            for i in range(begin, n):
                if i > begin and cands[i] == cands[i - 1]:
                    continue

                path.append(cands[i])
                DFS(i + 1, remain - cands[i], path)
                path.pop()

        DFS(0, target, [])
        return res


if __name__ == '__main__':
    candidates = [1, 1, 2, 5, 6, 7, 10]
    target = 8
    solution = Solution()
    res = solution.combinationSum2(candidates, target)
    print(res)
