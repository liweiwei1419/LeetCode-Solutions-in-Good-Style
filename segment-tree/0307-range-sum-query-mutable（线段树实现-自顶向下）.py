from typing import List


class NumArray:
    class SegmentTree:

        def __init__(self, arr, merge):
            self.data = arr
            # 开 4 倍大小的空间
            self.tree = [None for _ in range(4 * len(arr))]
            if not hasattr(merge, '__call__'):
                raise Exception('不是函数对象')
            self.merge = merge
            self.__build_segment_tree(0, 0, len(self.data) - 1)

        def get_size(self):
            return len(self.data)

        def get(self, index):
            if index < 0 or index >= len(self.data):
                raise Exception("Index is illegal.")
            return self.data[index]

        def __left_child(self, index):
            return 2 * index + 1

        def __right_child(self, index):
            return 2 * index + 2

        def __build_segment_tree(self, tree_index, data_l, data_r):
            # 区间只有 1 个数的时候，线段树的值，就是数组的值，不必做融合
            if data_l == data_r:
                self.tree[tree_index] = self.data[data_l]
                # 不要忘记 return
                return

            # 然后一分为二去构建
            mid = data_l + (data_r - data_l) // 2
            left_child = self.__left_child(tree_index)
            right_child = self.__right_child(tree_index)

            self.__build_segment_tree(left_child, data_l, mid)
            self.__build_segment_tree(right_child, mid + 1, data_r)

            # 左右都构建好以后，再构建自己，因此是后续遍历
            self.tree[tree_index] = self.merge(self.tree[left_child], self.tree[right_child])

        def __str__(self):
            # 打印线段树
            return str([str(ele) for ele in self.tree])

        def query(self, data_l, data_r):
            if data_l < 0 or data_l >= len(self.data) or data_r < 0 or data_r >= len(self.data) or data_l > data_r:
                raise Exception('Index is illegal.')
            return self.__query(0, 0, len(self.data) - 1, data_l, data_r)

        def __query(self, tree_index, tree_l, tree_r, data_l, data_r):
            # 一般而言，线段树区间肯定会大一些，所以会递归查询下去
            # 如果要查询的线段树区间和数据区间完全吻合，把当前线段树索引的返回回去就可以了
            if tree_l == data_l and tree_r == data_r:
                return self.tree[tree_index]

            mid = tree_l + (tree_r - tree_l) // 2
            # 线段树的左右两个索引
            left_child = self.__left_child(tree_index)
            right_child = self.__right_child(tree_index)

            # 因为构建时是这样
            # self.__build_segment_tree(left_child, data_l, mid)
            # 所以，如果右边区间不大于中间索引，就只须要在左子树查询就可以了
            if data_r <= mid:
                return self.__query(left_child, tree_l, mid, data_l, data_r)
            # 同理，如果左边区间 >= mid + 1，就只用在右边区间找就好了
            # self.__build_segment_tree(right_child, mid + 1, data_r)
            if data_l >= mid + 1:
                return self.__query(right_child, mid + 1, tree_r, data_l, data_r)
            # 横跨两边的时候，先算算左边，再算算右边
            left_res = self.__query(left_child, tree_l, mid, data_l, mid)
            right_res = self.__query(right_child, mid + 1, tree_r, mid + 1, data_r)
            return self.merge(left_res, right_res)

        def set(self, data_index, val):
            if data_index < 0 or data_index >= len(self.data):
                raise Exception('Index is illegal.')
            # 先把数据更新了
            self.data[data_index] = val
            # 线段树的更新递归去完成
            self.__set(0, 0, len(self.data) - 1, data_index, val)

        def __set(self, tree_index, tree_l, tree_r, data_index, val):
            if tree_l == tree_r:
                # 注意：这里不能填 tree_l 或者 tree_r
                self.tree[tree_index] = val
                return

            left_child = self.__left_child(tree_index)
            right_child = self.__right_child(tree_index)
            mid = tree_l + (tree_r - tree_l) // 2

            if data_index >= mid + 1:
                # 如果在右边，就只去右边更新
                self.__set(right_child, mid + 1, tree_r, data_index, val)
            if data_index <= mid:
                # 如果在左边，就只去左边更新
                self.__set(left_child, tree_l, mid, data_index, val)
            # 左边右边都更新完以后，再更新自己
            self.tree[tree_index] = self.merge(self.tree[left_child], self.tree[right_child])

    def __init__(self, nums):
        """
        :type nums: List[int]
        """

        self.size = len(nums)
        if self.size:
            self.st = NumArray.SegmentTree(nums, lambda a, b: a + b)

    def update(self, i, val):
        """
        :type i: int
        :type val: int
        :rtype: void
        """
        if self.size:
            self.st.set(i, val)

    def sumRange(self, i, j):
        """
        :type i: int
        :type j: int
        :rtype: int
        """
        if self.size:
            return self.st.query(i, j)

# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(i,val)
# param_2 = obj.sumRange(i,j)
