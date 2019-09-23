from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    # “模拟系统栈”实现的二叉树“中序遍历”（推荐）

    def inorderTraversal(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        # 1 表示递归处理
        stack = [(1, root)]
        res = []
        while stack:
            command, node = stack.pop()
            if command == 0:
                # 0 表示当前马上执行将结点的值添加到结果集中
                res.append(node.val)
            else:
                # 关键在这里：因为是模拟系统栈，应该把中序遍历的顺序倒过来写
                # 调整一下顺序就可以完成前序遍历和后序遍历
                if node.right:
                    stack.append((1, node.right))
                stack.append((0, node))
                if node.left:
                    stack.append((1, node.left))
        return res
