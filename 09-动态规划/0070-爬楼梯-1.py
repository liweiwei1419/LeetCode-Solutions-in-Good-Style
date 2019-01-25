class Solution:

    def climbStairs(self, n):
        if n == 0:
            return 1
        memo = [-1] * (n + 1)
        memo[0] = 1
        memo[1] = 1
        for i in range(2, n + 1):
            memo[i] = memo[i - 1] + memo[i - 2]
        return memo[n]


if __name__ == '__main__':
    s = Solution()
    res = s.climbStairs(2)
    print(res)
