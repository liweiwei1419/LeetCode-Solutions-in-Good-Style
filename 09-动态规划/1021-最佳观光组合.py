# 思路：动态规划

# dp[i] = max(A[i] + A[i - k] - k) ，其中 k = 1, 2, ..., i
# 变换一下写法，即
# dp[i] = max(A[i] + A[i - k] + i - k - i)
#       = max(A[i] - i + A[i - k] + (i - k))

# A[i] - i 是一部分，A[i - k] + (i - k) 是另一部分

# 参考资料：https://www.cnblogs.com/asenyang/p/10588246.html

class Solution:
    def maxScoreSightseeingPair(self, A: List[int]) -> int:
        size = len(A)
        if size == 0:
            return 0
        res = 0
        pre = A[0]

        for i in range(1, size):
            pre = max(pre, A[i - 1] + i - 1)
            res = max(res, A[i] - i + pre)
        return res
