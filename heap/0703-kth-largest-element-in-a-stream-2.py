from typing import List
import heapq


class KthLargest:

    # 思路：用最小堆

    def __init__(self, k: int, nums: List[int]):
        self.h = []
        self.k = k

        for num in nums:
            self.add(num)

    def add(self, val: int) -> int:
        if len(self.h) < self.k:
            heapq.heappush(self.h, val)
        else:
            if val <= self.h[0]:
                pass
            else:
                heapq.heappushpop(self.h, val)

        return self.h[0]


# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)

if __name__ == '__main__':
    nums = [4, 5, 8, 2]
    k = 3

    kl = KthLargest(k, nums)
    result = kl.add(3)
    print(result)

    result = kl.add(5)
    print(result)

    result = kl.add(10)
    print(result)

    result = kl.add(9)
    print(result)

    result = kl.add(4)
    print(result)
