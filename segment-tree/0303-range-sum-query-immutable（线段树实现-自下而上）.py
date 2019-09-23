from typing import List


class NumArray:
    class SegmentTree:

        # 自底向上的线段树实现

        def __init__(self, arr, merge):
            self.data = arr
            self.size = len(arr)
            # 开 2 倍大小的空间
            self.tree = [None for _ in range(2 * self.size)]
            if not hasattr(merge, '__call__'):
                raise Exception('不是函数对象')
            self.merge = merge

            # 原始数值赋值
            for i in range(self.size, 2 * self.size):
                self.tree[i] = self.data[i - self.size]
            # 从后向前赋值

            for i in range(self.size - 1, 0, -1):
                self.tree[i] = self.merge(self.tree[2 * i], self.tree[2 * i + 1])

        def get_size(self):
            return len(self.data)

        def query(self, l, r):
            l += self.size
            r += self.size

            res = 0
            while l <= r:
                if l & 1 == 1:
                    if res == 0:
                        res = self.tree[l]
                    else:
                        res = self.merge(res, self.tree[l])
                    l += 1
                if r & 1 == 0:
                    if res == 0:
                        res = self.tree[r]
                    else:
                        res = self.merge(res, self.tree[r])
                    r -= 1
                l //= 2
                r //= 2
            return res

    def __init__(self, nums: List[int]):
        """
        :type nums: List[int]
        """

        if len(nums) > 0:
            self.st = NumArray.SegmentTree(nums, lambda a, b: a + b)

    def sumRange(self, i: int, j: int) -> int:
        if self.st is None:
            return 0
        return self.st.query(i, j)

# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(i,j)
