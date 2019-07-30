from typing import List


# 本代码介绍了如何调试

class Solution:

    def __init__(self):
        self.target = None
        self.input = None
        self.res = []
        self.path = []

    def __dfs(self, begin, s):
        if s >= self.target or begin == len(self.input):
            if s == self.target:
                self.res.append(self.path.copy())
            return
        for i in range(begin, len(self.input)):
            if self.input[i] > self.target:
                continue

            # 加上这句就可以了
            if i > begin and self.input[i - 1] == self.input[i]:
                continue

            self.path.append(self.input[i])
            s += self.input[i]

            self.__dfs(i + 1, s)

            self.path.pop()
            s -= self.input[i]

    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:

        candidates.sort()
        print(candidates)
        self.input = candidates
        self.target = target

        self.__dfs(0, 0)
        return self.res


if __name__ == '__main__':
    candidates = [10, 1, 2, 7, 6, 1, 5]
    target = 8
    solution = Solution()
    result = solution.combinationSum2(candidates, target)
    print(result)
