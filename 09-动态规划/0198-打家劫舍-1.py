# 参考解答：https://blog.csdn.net/geekmanong/article/details/50320937

class Solution:
    def __init__(self):
        self.cache = None

    def _rob_house(self, nums, end_index):
        """
        考虑偷取 [0,...,end_index] 区间范围内的房子价值的最大者
        状态转移方程：
        f(l-1) = max(v(l-1) + f(l-3),
                     v(l-2) + f(l-4),
                     ...,
                     v(3) + f(1),
                     v(2) + f(0),
                     v(1),
                     v(0))

        :param nums:
        :param end_index:
        :return:
        """
        if end_index < 0:
            return 0
        if self.cache[end_index] != -1:
            return self.cache[end_index]

        max_val = 0
        for i in range(end_index, -1, -1):
            max_val = max(max_val, nums[i] + self._rob_house(nums, i - 2))
        self.cache[end_index] = max_val
        return max_val

    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = len(nums)
        if l == 0:
            return 0
        self.cache = [-1] * l
        return self._rob_house(nums, l - 1)


if __name__ == '__main__':
    s = Solution()

    res = s.rob([1])
    print(res)
