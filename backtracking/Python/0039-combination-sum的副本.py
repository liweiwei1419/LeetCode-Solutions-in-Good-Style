from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if (not candidates):
            return []
        n = len(candidates)
        res = []
        candidates.sort()

        def helper(i, tmp, target):
            if target == 0:
                res.append(tmp)
                return
            if i == n or target < candidates[i]:
                return
            helper(i, tmp + [candidates[i]], target - candidates[i])
            helper(i + 1, tmp, target)

        helper(0, [], target)
        return res


if __name__ == '__main__':
    candidates = [2, 3, 6, 7]
    target = 7

    solution = Solution()
    res = solution.combinationSum(candidates,target)
    print(res)

if __name__ == '__main__':
    arr = [[0] * 3] * 3
    print(arr)

    # 下面这一行同时修改了 arr[0][1]、arr[1][1]、arr[2][1]
    arr[0][1] = 1
    print(arr)
