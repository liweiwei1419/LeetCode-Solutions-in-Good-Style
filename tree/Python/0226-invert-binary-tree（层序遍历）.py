class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    # 层序遍历

    def invertTree(self, root: TreeNode) -> TreeNode:
        if root is None:
            return None

        queue = [root]

        while queue:
            cur_node = queue.pop(0)

            if cur_node.left or cur_node.right:
                cur_node.left, cur_node.right = cur_node.right, cur_node.left

                if cur_node.left:
                    queue.append(cur_node.left)
                if cur_node.right:
                    queue.append(cur_node.right)

        return root
