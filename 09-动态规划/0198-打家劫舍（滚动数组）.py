# 参考资料：https://blog.csdn.net/Koala_Tree/article/details/80015066


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
        pre = nums[0]
        cur = max(pre, nums[1])
        for i in range(2, len(nums)):
            temp = cur
            cur = max(pre + nums[i], cur)
            pre = temp
        return cur
