class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

# 分治法
class Solution:

    def __init__(self):
        self.nums = None

    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        self.nums = nums
        size = len(nums)

        return self.__dfs(0, size - 1)

    def __dfs(self, l, r):
        if l > r:
            return None
        if l == r:
            return TreeNode(self.nums[l])
        mid = l + (r - l) // 2
        root = TreeNode(self.nums[mid])
        root.left = self.__dfs(l, mid - 1)
        root.right = self.__dfs(mid + 1, r)
        return root



