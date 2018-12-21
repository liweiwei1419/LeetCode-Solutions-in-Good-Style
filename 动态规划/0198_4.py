# @Time    : 18/4/11 下午4:55
# @Author  : liweiwei1419
# @Site    : http://www.liwei.party/
# @Contact : liweiwei1419@gmail.com


class Solution:

    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n == 0:
            return 0
        if n <= 2:
            return max(nums)
        pp = nums[0]
        p = max(pp, nums[1])
        for i in range(2, len(nums)):
            tmp = p
            p = max(pp + nums[i], p)
            pp = tmp

        return p
