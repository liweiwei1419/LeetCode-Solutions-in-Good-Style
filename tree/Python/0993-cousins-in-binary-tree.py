class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def isCousins(self, root: 'TreeNode', x: 'int', y: 'int') -> 'bool':
        if not root:
            return False
        queue = [root]
        while queue:
            # 循环开始时，队列中的元素个数就是当前层结点的个数
            size = len(queue)
            # 把一层的结点值都放进来，如果遇到空结点，放置 0，
            # 题目中说"每个节点的值都是唯一的、范围为 1 到 100 的整数。"
            # 所以，你放 101 都是可以的
            cur_level = []
            for _ in range(size):
                top = queue.pop(0)
                if top:
                    cur_level.append(top.val)
                    queue.append(top.left)
                    queue.append(top.right)
                else:
                    cur_level.append(0)

            # 如果这两个索引都在一层，只有一种情况需要排除
            # 那就是两个结点挨着，并且索引小的结点的索引序号是偶数
            if x in cur_level and y in cur_level:
                index1 = cur_level.index(x)
                index2 = cur_level.index(y)
                if index1 > index2:
                    index1, index2 = index2, index1
                if index1 + 1 == index2 and index1 & 1 == 0:
                    return False
                return True
            # 如果索引不在同一层，直接就可以返回不是堂兄弟结点了
            if x in cur_level or y in cur_level:
                return False
        return False
