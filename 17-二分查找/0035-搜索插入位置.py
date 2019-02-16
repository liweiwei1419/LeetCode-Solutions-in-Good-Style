class Solution:

    # 返回的是大于等于 target 的索引，有可能是最后一个

    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        size = len(nums)
        if size == 0:
            return 0

        l = 0
        r = size
        while l < r:
            mid = l + (r - l) // 2
            if nums[mid] >= target:
                r = mid
            else:
                assert nums[mid] < target
                # [1,5,7] 2
                l = mid + 1
        return l


if __name__ == '__main__':
    nums = [1, 3, 5, 6]
    target = 5
    solution = Solution()
    result = solution.searchInsert(nums, target)
    print(result)
