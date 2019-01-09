# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """

        res = []
        if root is None:
            return res

        if root.left is None and root.right is None:
            if root.val == sum:
                temp1 = [root.val]
                res.append(temp1)
                return res

        left_list_list = self.pathSum(root.left, sum - root.val)
        self.__merge_one_list(root, left_list_list, res)

        right_list_list = self.pathSum(root.right, sum - root.val)
        self.__merge_one_list(root, right_list_list, res)
        return res


    # 这个方法过于复杂，也不太好理解
    @staticmethod
    def __merge_one_list(node, temp_list_list, res):
        for temp_list in temp_list_list:
            l = [node.val]
            l.extend(temp_list)
            res.append(l)
