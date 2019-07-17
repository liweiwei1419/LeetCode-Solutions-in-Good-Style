from typing import List


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        size = len(candidates)

        if size == 0:
            return []

        res = []
        path = []
        candidates.sort()

        self.__dfs(candidates, 0, size, path, res, target)
        return res

    def __dfs(self, candidates, begin, size, path, res, target):

        if target == 0:
            res.append(path[:])
            return

        for index in range(begin, size):
            residuce = target - candidates[index]
            if residuce < 0:
                break
            # 注意：这里是 begin
            if index > begin and candidates[index - 1] == candidates[index]:
                continue
            path.append(candidates[index])
            self.__dfs(candidates, index + 1, size, path, res, residuce)
            path.pop()


if __name__ == '__main__':
    candidates = [10, 1, 2, 7, 6, 1, 5]
    target = 8

    # candidates = [2, 5, 2, 1, 2]
    # target = 5
    solution = Solution()
    result = solution.combinationSum2(candidates, target)
    print(result)
