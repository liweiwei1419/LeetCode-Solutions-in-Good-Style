# 108. 将有序数组转换为二叉搜索树
# Definition for a binary tree node.
# 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
# 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    def sortedArrayToBST(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        if len(nums) == 0:
            return None
        return self.__helper(nums, 0, len(nums) - 1)

    def __helper(self, nums, left, right):
        # 写递归问题是有套路的，先写递归终止条件，然后再写递归流程
        if left > right:
            return None
        if left == right:
            return TreeNode(nums[left])
        mid = left + (right - left) // 2
        root = TreeNode(nums[mid])
        root.left = self.__helper(nums, left, mid - 1)
        root.right = self.__helper(nums, mid + 1, right)
        return root
