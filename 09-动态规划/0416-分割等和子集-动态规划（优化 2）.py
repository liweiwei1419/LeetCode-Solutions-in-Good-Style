from typing import List


class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        size = len(nums)
        if size == 0:
            return False
        s = sum(nums)
        if s & 1 == 1:
            return False

        target = s // 2
        dp = [False for _ in range(target + 1)]

        # 状态转移方程：dp[i - 1][j] = dp[i - 1][j] or dp[i - 1][j - nums[i]]
        # 单独 1 个数可以构成子集，根据状态转移方程，当 j == nums[i] 成立的时候，会来看 dp[i - 1][0] 的值
        # 因此根据语义，dp[0] 应该设置为 True
        dp[0] = True

        for j in range(target + 1):
            if nums[0] == j:
                dp[j] = True
                break

        for i in range(1, size):

            # 先看最后一个数是不是返回 True，如果是后面就没有必要计算了，方法可以直接返回 True
            dp[-1] = dp[-1] or dp[target - nums[i]]
            if dp[-1]:
                return True

            # 然后再写倒数第 2 个数，倒数第 3 个数
            for j in range(target - 1, -1, -1):
                if j >= nums[i]:
                    dp[j] = dp[j] or dp[j - nums[i]]
                else:
                    break
        return dp[-1]


if __name__ == '__main__':
    nums = [1, 5, 11, 5]

    s = Solution()
    res = s.canPartition(nums)
    print(res)
