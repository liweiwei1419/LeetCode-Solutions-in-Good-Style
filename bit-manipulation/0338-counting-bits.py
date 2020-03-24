from typing import List


class Solution:

    # 难理解

    def countBits(self, num: int) -> List[int]:
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
