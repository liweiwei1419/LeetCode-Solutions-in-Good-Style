class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# 这种写法是错的

class Solution:

    def kthSmallest(self, root: TreeNode, k: int) -> int:
        # 使用递归的方法，中序遍历
        if root.left:
            # 不是空，才继续遍历
            return self.kthSmallest(root.left, k)

        k -= 1
        if k == 0:
            return root.val

        if root.right:
            return self.kthSmallest(root.right, k)


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
