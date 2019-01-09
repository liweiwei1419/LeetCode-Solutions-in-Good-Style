# 55. 跳跃游戏
# 给定一个非负整数数组，你最初位于数组的第一个位置。
#
# 数组中的每个元素代表你在该位置可以跳跃的最大长度。
#
# 判断你是否能够到达最后一个位置。


class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        l = len(nums)
        if l == 0:
            return True
        max_arrive = nums[0]
        for i in range(1, l):
            if i > max_arrive:
                return False
            else:
                max_arrive = max(max_arrive, i + nums[i])
        return True


