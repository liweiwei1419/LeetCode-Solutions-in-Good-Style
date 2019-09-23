from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    # 队列

    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        if root is None:
            return []

        queue = [root]
        res = []
        turn_left = True
        while queue:
            cur_list = []
            size = len(queue)
            for _ in range(size):
                top = queue.pop(0)

                if turn_left:
                    cur_list.append(top.val)
                else:
                    cur_list.insert(0, top.val)

                if top.left:
                    queue.append(top.left)
                if top.right:
                    queue.append(top.right)
            res.append(cur_list)
            turn_left = not turn_left
        return res
