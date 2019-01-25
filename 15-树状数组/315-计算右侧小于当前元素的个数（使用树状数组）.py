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

        class FenwickTree:
            def __init__(self, n):
                self.size = n
                self.tree = [0 for _ in range(n + 1)]

            def __lowbit(self, index):
                return index & (-index)

            # 单点更新：从下到上，最多到 size，可以取等
            def update(self, index, delta):
                while index <= self.size:
                    self.tree[index] += delta
                    index += self.__lowbit(index)

            # 区间查询：从上到下，最少到 1，可以取等
            def query(self, index):
                res = 0
                while index > 0:
                    res += self.tree[index]
                    index -= self.__lowbit(index)
                return res

        l = len(nums)
        if l == 0:
            return []
        if l == 1:
            return [0]

        s = list(set(nums))
        import heapq
        heapq.heapify(s)
        index = 1

        size = len(s)
        rank_map = dict()
        ft = FenwickTree(size)
        for _ in range(size):
            num = heapq.heappop(s)
            rank_map[num] = index
            index += 1

        # 从后向前填表
        res = [None for _ in range(l)]
        for index in range(l - 1, -1, -1):
            rank = rank_map[nums[index]]
            ft.update(rank, 1)
            res[index] = ft.query(rank - 1)
        return res


if __name__ == '__main__':
    nums = [5, 2, 6, 1]
    solution = Solution()
    result = solution.countSmaller(nums)
    print(result)
