class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# 【不推荐的写法，推荐 0230_4 】这个写法不太好，因为可能把空结点入栈，出栈的时候还要判断结点是不是空

class Solution:

    # 模拟系统栈的方式实现，是一种比较通用的做法，
    # 可以作为二叉树的三种非递归遍历

    def kthSmallest(self, root: TreeNode, k: int) -> int:
        # 0 表示当前遍历到它，1 表示压入栈
        # 刚开始是 1 ，不要写成 0 了
        stack = [(1, root)]

        while stack:
            command, node = stack.pop()
            if node is None:
                # 不能写 return ，这不是递归
                continue
            if command == 0:
                k -= 1
                if k == 0:
                    return node.val
            else:

                # 此时 command == 1 的时候，表示递归遍历到的
                stack.append((1, node.right))
                stack.append((0, node))
                stack.append((1, node.left))
