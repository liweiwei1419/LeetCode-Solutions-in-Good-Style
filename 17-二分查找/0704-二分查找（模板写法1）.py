class Solution:
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        size = len(nums)
        if size == 0:
            return -1
        l = 0
        r = size - 1
        while l < r:
            mid = l + (r - l + 1) // 2
            if nums[mid] <= target:
                # mid 在，因此，不能排除 mid
                l = mid
            else:
                assert nums[mid] > target
                # mid 不在，所以可以排除 mid
                r = mid - 1
        # 为了避免不存在的情况出现，最后要判断一下
        if nums[l] == target:
            return l
        return -1
