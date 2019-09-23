from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        if len(nums) == 0:
            return None
        return self.__helper(nums, 0, len(nums) - 1)

    def __helper(self, nums, left, right):
        # 写递归问题是有套路的，先写递归终止条件，然后再写递归流程
        if left > right:
            return None
        if left == right:
            return TreeNode(nums[left])
        mid = (left + right) >> 1
        root = TreeNode(nums[mid])
        root.left = self.__helper(nums, left, mid - 1)
        root.right = self.__helper(nums, mid + 1, right)
        return root
