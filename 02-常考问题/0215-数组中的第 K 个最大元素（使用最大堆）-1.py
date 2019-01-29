import heapq


class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        l = [(-num, num) for num in nums]
        heapq.heapify(l)
        for _ in range(k):
            _, res = heapq.heappop(l)
        return res


if __name__ == '__main__':
    nums = [3, 2, 1, 5, 6, 4]
    k = 2
    solution = Solution()
    result = solution.findKthLargest(nums, k)
    print(result)
