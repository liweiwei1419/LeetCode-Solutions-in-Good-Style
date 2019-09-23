from typing import List


class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        class FenwickTree:
            def __init__(self, n):
                self.size = n
                self.tree = [0 for _ in range(n + 1)]

            def __lowbit(self, index):
                return index & (-index)

            # 单点更新：将 index 这个位置 + 1
            def update(self, index, delta):
                # 从下到上，最多到 size，可以等于 size
                while index <= self.size:
                    self.tree[index] += delta
                    index += self.__lowbit(index)

            # 区间查询：查询小于等于 index 的元素个数
            # 查询的语义是"前缀和"
            def query(self, index):
                res = 0
                # 从上到下，最少到 1，可以等于 1
                while index > 0:
                    res += self.tree[index]
                    index -= self.__lowbit(index)
                return res

        # 特判
        size = len(nums)
        if size == 0:
            return []
        if size == 1:
            return [0]

        # 去重，方便离散化
        s = list(set(nums))

        s_len = len(s)

        # 离散化，借助堆
        import heapq
        heapq.heapify(s)

        rank_map = dict()
        rank = 1
        for _ in range(s_len):
            num = heapq.heappop(s)
            rank_map[num] = rank
            rank += 1

        fenwick_tree = FenwickTree(s_len)

        # 从后向前填表
        res = [None for _ in range(size)]
        # 从后向前填表
        for index in range(size - 1, -1, -1):
            # 1、查询排名
            rank = rank_map[nums[index]]
            # 2、在树状数组排名的那个位置 + 1
            fenwick_tree.update(rank, 1)
            # 3、查询一下小于等于“当前排名 - 1”的元素有多少
            res[index] = fenwick_tree.query(rank - 1)
        return res


if __name__ == '__main__':
    nums = [5, 2, 6, 1]
    solution = Solution()
    result = solution.countSmaller(nums)
    print(result)
