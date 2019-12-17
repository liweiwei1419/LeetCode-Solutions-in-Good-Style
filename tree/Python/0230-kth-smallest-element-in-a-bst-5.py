class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        # 模拟使用递归的中序遍历
        # 显式使用 stack 保存方法的数据
        # 1 表示递归调用
        # 0 表示当前处理
        stack = [(1, root)]
        while stack:
            # 因为是栈，得从栈顶弹出元素
            command, node = stack.pop()

            if command == 0:
                # 0 表示当前处理
                k -= 1
                if k == 0:
                    return node.val

            else:
                # 1 表示递归调用，按照倒序写代码
                # 关键在这里：因为是模拟系统栈，应该把中序遍历的顺序倒过来写
                # 调整一下顺序就可以完成前序遍历和后序遍历
                if node.right:
                    stack.append((1, node.right))

                stack.append((0, node))

                if node.left:
                    stack.append((1, node.left))


if __name__ == '__main__':
    node3 = TreeNode(3)
    node1 = TreeNode(1)
    node4 = TreeNode(4)
    node2 = TreeNode(2)

    node3.left = node1
    node3.right = node4
    node1.right = node2

    solution = Solution()
    result = solution.kthSmallest(node3, k=1)
    print(result)
