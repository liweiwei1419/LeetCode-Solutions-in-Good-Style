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

        def set(self, i, val):
            i += self.size

            self.tree[i] = val
            while i > 0:
                left = i
                right = i
                if i & 1 == 0:
                    right = i + 1
                else:
                    left = i - 1
                if left == 0:
                    self.tree[i // 2] = self.tree[right]
                else:
                    self.tree[i // 2] = self.merge(self.tree[left], self.tree[right])
                i //= 2

    def __init__(self, nums: List[int]):
        self.size = len(nums)
        if self.size:
            self.st = NumArray.SegmentTree(nums, lambda a, b: a + b)

    def update(self, i: int, val: int) -> None:
        if self.size:
            self.st.set(i, val)

    def sumRange(self, i: int, j: int) -> int:
        if self.size:
            return self.st.query(i, j)

# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(i,val)
# param_2 = obj.sumRange(i,j)
