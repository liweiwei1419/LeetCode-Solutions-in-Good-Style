class Solution:

    def __init__(self):
        self.cache = None

    def __try_partition(self, nums, index, C):
        """
        给定 nums 表示给出的容量，考虑索引区间 [0, index] ，是否能够得到 sum_
        分类讨论的标准就是要不要 nums[index] 这个物品
        f(i,j) = f(i-1,j) or f(i,j-nums[i])
        :param nums:
        :param index:
        :param C:
        :return:
        """

        # 先写递归终止条件
        if C == 0:
            return True
        if index < 0 or C < 0:
            return False

        if self.cache[index][C]:
            return self.cache[index][C]

        # 情况1：不考虑 nums[index] 这个物品，看看能不能满足条件
        res = self.__try_partition(nums, index - 1, C)
        # 情况2：考虑 nums[index] 这个物品，如果它可以放进背包
        if nums[index] <= C:
            res = res or self.__try_partition(nums, index - 1, C - nums[index])
        self.cache[index][C] = res
        return res

    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """

        l = len(nums)
        if l == 0:
            return False
        # 特判：如果价值为奇数，不可以，直接返回 False
        s = sum(nums)
        if s & 1 == 1:
            return False
        half = s // 2
        self.cache = [[None for _ in range(half + 1)] for _ in range(l)]
        return self.__try_partition(nums, l - 1, half)


if __name__ == '__main__':
    # nums = [1, 5, 11, 5]

    nums = [100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
            100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
            100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
            100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
            100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100]

    s = Solution()
    res = s.canPartition(nums)
    print(res)
