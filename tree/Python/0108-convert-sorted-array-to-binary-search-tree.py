from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        def helper(nums, left, right):
            if left > right:
                return None

            if left == right:
                return TreeNode(nums[left])

            mid = (left + right) >> 1
            root = TreeNode(nums[mid])
            root.left = helper(nums, left, mid - 1)
            root.right = helper(nums, mid + 1, right)
            return root

        size = len(nums)
        if size == 0:
            return None
        return helper(nums, 0, size - 1)
