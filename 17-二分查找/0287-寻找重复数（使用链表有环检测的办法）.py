class Solution(object):
    def findDuplicate(self, nums):
        # 参考了：https://blog.csdn.net/wr339988/article/details/53617914
        # 参考资料：http://www.cnblogs.com/grandyang/p/4843654.html
        # 看下来，其实就是 LeetCode 141 和 142
        # 会了这两题，其实这道题的这个解法就迎刃而解了
        """
        :type nums: List[int]
        :rtype: int
        """

        fast = 0
        slow = 0

        while True:
            fast = nums[nums[fast]]
            slow = nums[slow]

            if fast == slow:
                break

        point = 0
        while point != slow:
            point = nums[point]
            slow = nums[slow]
        return point
