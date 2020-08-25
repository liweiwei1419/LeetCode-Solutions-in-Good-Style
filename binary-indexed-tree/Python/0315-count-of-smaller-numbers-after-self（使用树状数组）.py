from typing import List


class Solution:

    def countSmaller(self, nums: List[int]) -> List[int]:

        class FenwickTree:
            def __init__(self, n):
                self.size = n
                self.tree = [0 for _ in range(n + 1)]

            def __lowbit(self, x):
                return x & (-x)

            def update(self, index, delta):
                # 树状数组的长度与输入数组的长度一致
                while index <= self.size:
                    self.tree[index] += delta
                    index += self.__lowbit(index)

            def query(self, index):
                sum = 0
                # 下标从 1 开始，所以到 index == 0 的时候停止
                while index > 0:
                    sum += self.tree[index]
                    index -= self.__lowbit(index)
                return sum

        size = len(nums)
        if size == 0:
            return []
        if size == 1:
            return [0]

        s = list(set(nums))
        s_len = len(s)

        # 离散化
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
