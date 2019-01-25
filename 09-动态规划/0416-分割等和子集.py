class Solution:

    def __init__(self):
        self.cache = None

    def __try_partition(self, nums, index, sum_):
        """
        f(i,j) = f(i-1,j) || f(i,j-nums[i])
        :param nums:
        :param index:
        :param C:
        :return:
        """
        if sum_ == 0:
            return True
        if index < 0 or sum_ < 0:
            return False

        if self.cache[index][sum_] != 0:
            return self.cache[index][sum_]

        res = self.__try_partition(nums, index - 1, sum_)
        if nums[index] <= sum_:
            res = res or self.__try_partition(nums, index - 1, sum_ - nums[index])
        self.cache[index][sum_] = res
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
        self.cache = [[0 for _ in range(half + 1)] for _ in range(l)]
        return self.__try_partition(nums, l - 1, half)


if __name__ == '__main__':
    # nums = [1, 5, 11, 5]
    import time

    begin = time.time()
    nums = [100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
            100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
            100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
            100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
            100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100]
    print(len(nums))
    s = Solution()
    res = s.canPartition(nums)
    end = time.time()
    print(end - begin)
    print(res)
