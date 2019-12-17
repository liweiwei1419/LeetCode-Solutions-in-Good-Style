from typing import List
import heapq


# 默认实现就是一个最小堆


class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.k = k
        # 这是堆，我们定义成一个成员变量
        # 使用 Python 提供的 heapq 帮助我们完成操作
        # 这是复制，numpy 中是视图
        self.h = []
        for num in nums:
            self.add(num)

    def add(self, val: int) -> int:
        if len(self.h) < self.k:
            heapq.heappush(self.h, val)
            return self.h[0]

        if val <= self.h[0]:
            return self.h[0]
        heapq.heapreplace(self.h, val)
        return self.h[0]


# 参考资料：
# 1、https://docs.python.org/3/library/heapq.html
# 2、https://www.cnblogs.com/Joyce-song94/p/7149440.html


# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)

if __name__ == '__main__':
    arr = [4, 5, 8, 2]

    k = KthLargest(3, arr)

    result = k.add(3)
    print(result)
    result = k.add(5)
    print(result)
    result = k.add(10)
    print(result)
    result = k.add(9)
    print(result)
    result = k.add(4)
    print(result)
