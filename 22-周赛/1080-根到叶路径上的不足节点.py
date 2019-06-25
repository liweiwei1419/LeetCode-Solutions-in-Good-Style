class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

# 算法思想：分治法
# 后序遍历：dfs 的返回值是：是否删除这个节点

class Solution:

    def __dfs(self, node, s, limit):
        """
        后序遍历
        :param node: 当前遍历的结点
        :param s: 当前累计的和
        :param limit: 题目中给出的 limit
        :return: 是否要删除 node 这个结点，True 表示要删除，False 表示不删除
        """
        # 先写递归终止条件：如果小于 limit，根据题意，要删除
        if node.left is None and node.right is None:
            return s + node.val < limit

        # 默认为左右结点均剪枝
        # 注意：初值不能设置成 False
        # 因为，当左右子树只有一个存在的时候，这个子树的逻辑值直接决定了父结点是否被删除
        l_tree_deleted = True
        r_tree_deleted = True

        # 如果有左子树，就先递归处理左子树
        if node.left:
            l_tree_deleted = self.__dfs(node.left, s + node.val, limit)

        # 如果有右子树，就先递归处理右子树
        if node.right:
            r_tree_deleted = self.__dfs(node.right, s + node.val, limit)

        # 左右子树是否删除的结论得到了，由自己来执行是否删除它们
        if l_tree_deleted:
            node.left = None
        if r_tree_deleted:
            node.right = None

        # 只有左右子树都被删除了，自己才没有必要保留
        return l_tree_deleted and r_tree_deleted

    def sufficientSubset(self, root: TreeNode, limit: int) -> TreeNode:
        root_deleted = self.__dfs(root, 0, limit)
        if root_deleted:
            return None
        return root


if __name__ == '__main__':
    print(True or False)
    print(True and False)
