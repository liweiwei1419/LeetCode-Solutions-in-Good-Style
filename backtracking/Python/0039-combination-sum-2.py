from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:

        # 直接用 res 就可以
        res = []

        def dfs(candidates, path):
            # 这里 sum 函数得做一次遍历求和运算，是消耗时间的
            if sum(path) > target:
                return

            if sum(path) == target:
                res.append(path[:])
                # 这里就可以直接 return，因为后面再搜索也得不到结果（待讨论，测试下来的确可以）
                return

            for i in range(len(candidates)):
                path.append(candidates[i])
                dfs(candidates[i:], path)
                # 用 pop() 语义更清晰
                path.pop()

        dfs(candidates, [])
        return res


if __name__ == '__main__':
    candidates = [2, 3, 6, 7]
    target = 7

    solution = Solution()
    res = solution.combinationSum(candidates, target)
    print(res)

    l1 = candidates[1:]
    print(l1)

    l1[0] = 10000

    print(candidates)

#
# if __name__ == '__main__':
#     arr = [[0] * 3] * 3
#     print(arr)
#
#     # 下面这一行同时修改了 arr[0][1]、arr[1][1]、arr[2][1]
#     arr[0][1] = 1
#     print(arr)
