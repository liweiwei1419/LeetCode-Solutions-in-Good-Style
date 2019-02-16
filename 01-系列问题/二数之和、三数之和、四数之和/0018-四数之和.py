# 18. 四数之和
# 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
# 判断 nums 中是否存在四个元素 a，b，c 和 d ，
# 使得 a + b + c + d 的值与 target 相等？
# 找出所有满足条件且不重复的四元组。
# 注意：
# 答案中不可以包含重复的四元组。

class Solution:
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
