from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        assert len(inorder) == len(postorder)

        if len(inorder) == 0:
            return None
        if len(inorder) == 1:
            # 这里要返回结点，而不是返回具体的数
            return TreeNode(inorder[0])
        # 后序遍历的最后一个结点就是根结点
        root = TreeNode(postorder[-1])
        # 在中序遍历中找到根结点的索引，得到左右子树的一个划分
        pos = inorder.index(postorder[-1])
        # 这里的列表切片使用的是复制值，使用了一些空间，因此空间复杂度是 O(N)
        root.left = self.buildTree(inorder[:pos], postorder[:pos])
        root.right = self.buildTree(inorder[pos + 1:], postorder[pos:-1])
        return root


# 用于验证的方法
def validate(node):
    if node is None:
        return
    validate(node.left)
    print(node.val, end=' ')
    validate(node.right)


if __name__ == '__main__':
    inorder = [9, 3, 15, 20, 7]
    postorder = [9, 15, 7, 20, 3]
    solution = Solution()
    root = solution.buildTree(inorder, postorder)
    validate(root)

    arr1 = [1, 2, 3, 4]
    arr2 = arr1[2:3]

    print(arr1)
    print(arr2)

    arr2[0] = 100

    print(arr1)
    print(arr2)
