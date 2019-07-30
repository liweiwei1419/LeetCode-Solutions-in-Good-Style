class Solution:
    def __init__(self):
        self.memo = []

    def integerBreak(self, n):
        self.memo = [-1 for _ in range(n + 1)]
        self.memo[0] = 1
        self.memo[1] = 1
        return self.__dfs(n)

    def __dfs(self, n):
        if n == 1:
            return 1
        if self.memo[n] == -1:
            res = 0
            for i in range(1, n):
                res = max(res, i * (n - i), i * self.__dfs(n - i))
            self.memo[n] = res
        return self.memo[n]


if __name__ == '__main__':
    n = 10
    s = Solution()
    res = s.integerBreak(n)
    print(res)
