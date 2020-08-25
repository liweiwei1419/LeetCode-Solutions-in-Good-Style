from typing import List


class Solution:

    def countSmaller(self, nums: List[int]) -> List[int]:
        class TreeNode:
            def __init__(self, val):
                self.left = None
                self.right = None
                self.val = val
                self.left_node_sum = 0
                self.duplicate_times = 1

        def insert(node, val, index, cum_left_nodeSum, counter):
            if node is None:
                node = TreeNode(val)
                counter[index] = cum_left_nodeSum
                return node
            if node.val == val:
                node.duplicate_times += 1
                counter[index] = cum_left_nodeSum + node.left_node_sum
            elif node.val > val:
                node.left_node_sum += 1
                node.left = insert(node.left, val, index, cum_left_nodeSum, counter)
            else:
                node.right = insert(node.right, val, index,
                                    cum_left_nodeSum + node.duplicate_times + node.left_node_sum, counter)
            return node

        size = len(nums)
        if size == 0:
            return []
        if size == 1:
            return [0]

        # 从后向前填表
        res = [0 for _ in range(size)]
        root = None
        for index in range(size - 1, -1, -1):
            root = insert(root, nums[index], index, 0, res)
        return res


if __name__ == '__main__':
    nums = [5, 2, 6, 1]
    solution = Solution()
    result = solution.countSmaller(nums)
    print(result)
