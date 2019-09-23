class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# 算法思想：分治法
# 后序遍历：dfs 的返回值是：是否保留这个节点

class Solution:
    def __dfs(self, node, s, limit):
        """
        后序遍历
        :param node: 当前遍历的结点
        :param s: 当前累计的和
        :param limit: 题目中给出的 limit
        :return: 是否要保留 node 这个结点，True 表示要保留，False 表示不保留
        """
        # 先写递归终止条件：如果大于等于 limit，根据题意，要保留
        if node.left is None and node.right is None:
            return node.val + s >= limit

        # 默认为左右结点均剪枝
        # 注意：初值不能设置成 True
        # 因为，当左右子树只有一个存在的时候，这个子树的逻辑值直接决定了父结点是否被保留
        ltree_saved = False
        rtree_saved = False

        # 如果有左子树，就先递归处理左子树
        if node.left:
            ltree_saved = self.__dfs(node.left, s + node.val, limit)
        # 如果有右子树，就先递归处理右子树
        if node.right:
            rtree_saved = self.__dfs(node.right, s + node.val, limit)

        # 左右子树是否保留的结论得到了，由自己来执行是否保留它们
        if not ltree_saved:
            node.left = None
        if not rtree_saved:
            node.right = None

        # 只要左右结点有一个被保留，这个结点就得被保留
        return ltree_saved or rtree_saved

    def sufficientSubset(self, root: TreeNode, limit: int) -> TreeNode:
        root_saved = self.__dfs(root, 0, limit)
        if not root_saved:
            return None
        return root
