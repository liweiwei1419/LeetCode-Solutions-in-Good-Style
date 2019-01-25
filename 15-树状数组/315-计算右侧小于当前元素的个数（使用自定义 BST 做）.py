# 315. 计算右侧小于当前元素的个数
# 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
#
# 示例:
#
# 输入: [5,2,6,1]
# 输出: [2,1,1,0]
# 解释:
# 5 的右侧有 2 个更小的元素 (2 和 1).
# 2 的右侧仅有 1 个更小的元素 (1).
# 6 的右侧有 1 个更小的元素 (1).
# 1 的右侧有 0 个更小的元素.

class Solution:

    def countSmaller(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """

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

        l = len(nums)
        if l == 0:
            return []
        if l == 1:
            return [0]

        # 从后向前填表
        res = [None for _ in range(l)]
        root = None
        for index in range(l - 1, -1, -1):
            root = insert(root, nums[index], index, 0, res)
        return res


if __name__ == '__main__':
    nums = [5, 2, 6, 1]
    solution = Solution()
    result = solution.countSmaller(nums)
    print(result)
