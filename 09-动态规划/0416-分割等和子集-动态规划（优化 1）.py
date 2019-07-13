from typing import List


class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        size = len(nums)
        if size == 0:
            return False
        s = sum(nums)
        if s & 1 == 1:
            return False

        # 从第 2 行以后，当前行的结果参考了上一行的结果，因此使用一维数组定义状态就可以了
        target = s // 2
        dp = [False for _ in range(target + 1)]

        # 看看第 1 个数是不是能够刚好填满容量为 target
        for j in range(target + 1):
            if nums[0] == j:
                dp[j] = True
                # 如果等于，后面就不用做判断了，因为 j 会越来越大，肯定不等于 nums[0]
                break

        # 注意：因为后面的参考了前面的，我们从后向前填写
        for i in range(1, size):
            for j in range(target, -1, -1):
                if j >= nums[i]:
                    dp[j] = dp[j] or dp[j - nums[i]]
                else:
                    # 后面的容量越来越小，因此没有必要再判断了，退出当前循环
                    break
        return dp[-1]


if __name__ == '__main__':
    nums = [1, 5, 11, 5]

    s = Solution()
    res = s.canPartition(nums)
    print(res)
