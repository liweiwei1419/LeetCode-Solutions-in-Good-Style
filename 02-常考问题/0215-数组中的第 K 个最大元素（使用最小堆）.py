import heapq


# 还可以参考：https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/167837/Python-or-tm

class Solution(object):

    # 使用容量为 k 的小顶堆
    # 元素个数小于 k 的时候，放进去就是了
    # 元素个数大于 k 的时候，小于堆顶元素，就扔掉，大于堆顶元素，就替换

    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        size = len(nums)
        if k > size:
            raise Exception('程序出错')
        L = []
        for index in range(k):
            heapq.heappush(L, nums[index])
        for index in range(k, size):
            top = L[0]
            if nums[index] > top:
                # 看一看堆顶的元素，只要比堆顶元素大，就替换堆顶元素
                heapq.heapreplace(L, nums[index])
        # 最后堆顶中的元素就是堆中最小的，整个数组中的第 k 大元素
        return L[0]


if __name__ == '__main__':
    nums = [3, 7, 8, 1, 2, 4]
    solution = Solution()
    result = solution.findKthLargest(nums, 2)
    print(result)
