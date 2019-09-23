from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    # 分治法

    nums = None

    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        self.nums = nums
        size = len(nums)

        return self.__dfs(0, size - 1)

    def __dfs(self, left, right):
        if left > right:
            return None
        if left == right:
            return TreeNode(self.nums[left])
        mid = (left + right) >> 1
        root = TreeNode(self.nums[mid])
        root.left = self.__dfs(left, mid - 1)
        root.right = self.__dfs(mid + 1, right)
        return root
