from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def binaryTreePaths(self, root: TreeNode) -> List[str]:
        def helper(root, path, res):
            if root is None:
                return True
            path.append(str(root.val))
            left = helper(root.left, path, res)
            right = helper(root.right, path, res)
            if left and right:
                # 如果左边右边都为空，沿途的路径就要结算了
                res.append('->'.join(path))
            # 关键
            path.pop()
            # False 代表空集
            return False

        res = []
        helper(root, [], res)
        return res


if __name__ == '__main__':
    node1 = TreeNode(1)
    node2 = TreeNode(2)
    node3 = TreeNode(3)
    node5 = TreeNode(5)

    node1.left = node2
    node1.right = node3
    node2.right = node5

    solution = Solution()
    result = solution.binaryTreePaths(node1)
    print(result)
