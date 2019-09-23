class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> int:
        from collections import defaultdict
        memo = defaultdict(int)
        # 记忆化递归，memo 表示缓存
        memo[0] = 1  # 表示 cur - sum = 0, return 1
        self.res = 0

        def helper(root, curSum):
            if root is None:
                return
            curSum += root.val
            self.res += memo[curSum - sum]
            memo[curSum] += 1

            helper(root.left, curSum)
            helper(root.right, curSum)
            memo[curSum] -= 1

        helper(root, 0)
        return self.res
