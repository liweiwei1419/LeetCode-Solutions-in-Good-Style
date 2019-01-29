class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def __init__(self):
        self.counter = 0
        self.res = 0

    def kthSmallest(self, root, k):
        # 使用递归的方法，中序遍历
        if root.left:
            # 不是空，才继续遍历
            self.kthSmallest(root.left, k)
        self.counter += 1
        # print(root.val)
        if self.counter == k:
            # 注意：千万不能在这里返回，后序遍历还要继续进行下去
            self.res = root.val
            return
        if root.right:
            self.kthSmallest(root.right, k)
        return self.res


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
