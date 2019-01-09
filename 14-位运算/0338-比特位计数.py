# 338. 比特位计数
# 给定一个非负整数 num。
# 对于 0 ≤ i ≤ num 范围中的每个数字 i ，
# 计算其二进制数中的 1 的数目并将它们作为数组返回。
class Solution:
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        if num == 0:
            return [0]
        dp = [0] * (num + 1)
        for i in range(1, num + 1):
            dp[i] = dp[i & (i - 1)] + 1
        return dp


if __name__ == '__main__':
    solution = Solution()
    num = 5
    result = solution.countBits(num)
    print(result)
