


class Solution:
    def containsNearbyAlmostDuplicate(self, nums, k, t):
        """
        :type nums: List[int]
        :type k: int
        :type t: int
        :rtype: bool
        """

        # 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
        # 使得 nums[i] 和 nums[j] 的差的绝对值最大为 t，
        # 并且 i 和 j 之间的差的绝对值最大为 ķ。
