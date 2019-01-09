# @Time    : 18/4/11 上午11:53
# @Author  : liweiwei1419
# @Site    : http://www.liwei.party/
# @Contact : liweiwei1419@gmail.com


class Solution:
    def __init__(self):
        self.cache = None

    def _rob_house(self, nums, begin_index):
        """
        考虑偷取 [begin_index,len(num-1)] 这些房子的物品，价值之和最大为多少
        状态转移方程是：
        f(0) = max(v(0) + f(2),v(1) + f(3),...,v(n-3) + f(n-1),v(n-2),v(n-1))
        :param nums:
        :param begin_index:
        :return:
        """

        l = len(nums)
        if begin_index >= l:
            return 0
        if self.cache[begin_index] != -1:
            return self.cache[begin_index]
        max_val = 0
        for i in range(begin_index, l):
            max_val = max(max_val, nums[i] + self._rob_house(nums, i + 2))
        self.cache[begin_index] = max_val
        return max_val

    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n == 0:
            return 0
        self.cache = [-1] * n
        return self._rob_house(nums, 0)


if __name__ == '__main__':
    s = Solution()

    res = s.rob(
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
         0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
         0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0])
    print(res)
