import heapq


class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        # 比较规范的 heapq 的使用方法，传入 tuple
        l = [(-num, num) for num in nums]
        heapq.heapify(l)
        for _ in range(k - 1):
            heapq.heappop(l)
        return l[0][1]


if __name__ == '__main__':
    nums = [3, 2, 1, 5, 6, 4]
    k = 2
    solution = Solution()
    result = solution.findKthLargest(nums, k)
    print(result)
