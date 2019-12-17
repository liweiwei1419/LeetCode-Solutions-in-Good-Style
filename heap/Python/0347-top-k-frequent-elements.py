from typing import List


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        import heapq
        import collections

        # 堆有序数组
        l = []

        wordcount = collections.defaultdict(int)
        for num in nums:
            wordcount[num] += 1

        for key, val in wordcount.items():
            heapq.heappush(l, (-val, key))
        res = []
        for _ in range(k):
            _, key = heapq.heappop(l)
            res.append(key)
        return res


if __name__ == '__main__':
    solution = Solution()
    nums = [1, 1, 1, 2, 2, 3]
    k = 2
    result = solution.topKFrequent(nums, k)
    print(result)
