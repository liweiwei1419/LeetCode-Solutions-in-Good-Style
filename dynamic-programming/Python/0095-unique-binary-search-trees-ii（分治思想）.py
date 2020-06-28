from typing import List

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def generateTrees(self, n: int) -> List[TreeNode]:
        res = []
        if n <= 0:
            return res
        return self.helper(1, n)

    def helper(self, left, right):
        res = []
        if left > right:
            # 说明不构成区间，应该返回空结点
            res.append(None)
            return res
        elif left == right:
            res.append(TreeNode(left))
            return res
        else:
            for i in range(left, right + 1):
                left_sub_tree = self.helper(left, i - 1)
                right_sub_tree = self.helper(i + 1, right)
                for l in left_sub_tree:
                    for r in right_sub_tree:
                        root = TreeNode(i)
                        root.left = l
                        root.right = r
                        res.append(root)
        return res
