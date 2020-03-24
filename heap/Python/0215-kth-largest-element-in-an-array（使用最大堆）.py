from typing import List
import heapq


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # 比较规范的 heapq 的使用方法，传入 tuple
        # 参考：https://docs.python.org/zh-cn/3/library/heapq.html
        h = [(-num, num) for num in nums]
        heapq.heapify(h)
        for _ in range(k - 1):
            heapq.heappop(h)
        return h[0][1]


if __name__ == '__main__':
    nums = [3, 2, 1, 5, 6, 4]
    k = 2
    solution = Solution()
    result = solution.findKthLargest(nums, k)
    print(result)
