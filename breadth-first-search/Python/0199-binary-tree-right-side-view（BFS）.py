from typing import List
from collections import deque


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if root is None:
            return []

        res = []
        queue = deque()
        queue.append(root)
        while queue:
            cur_size = len(queue)
            res.append(queue[-1].val)
            # 这里要注意，上一层的结点要全部出列
            for _ in range(cur_size):
                top = queue.popleft()
                if top.left:
                    queue.append(top.left)
                if top.right:
                    queue.append(top.right)
        return res
