from typing import List

# 该算法超时，不采用

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        size = len(envelopes)
        # 特判
        if size < 2:
            return size

        # 对第一列排序，按照宽度排序（按照高度排序亦可，只不过后面定义状态的时候就得定义宽度）
        envelopes.sort(key=lambda x: x[0])
        # print(envelopes)
        # 以 envelopes[i][1] 结尾的上升子序列的长度
        dp = [1 for _ in range(size)]
        for i in range(1, size):
            for j in range(i):
                # 注意宽度也要严格小于
                if envelopes[j][0] < envelopes[i][0] and envelopes[j][1] < envelopes[i][1]:
                    dp[i] = max(dp[i], dp[j] + 1)
        return max(dp)


if __name__ == '__main__':
    envelopes = [[4, 5], [4, 6], [6, 7], [2, 3], [1, 1]]
    solution = Solution()
    res = solution.maxEnvelopes(envelopes)
    print(res)
