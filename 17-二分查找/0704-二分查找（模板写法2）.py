class Solution:
    def search(self, nums: List[int], target: int) -> int:
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
            mid = l + (r - l) // 2
            if nums[mid] < target:
                # mid 可以排除，所以要 + 1
                l = mid + 1
            else:
                assert nums[mid] >= target
                # mid 不能排除，所以至少是 mid 这个位置
                r = mid
        # 为了避免不存在的情况出现，最后要判断一下
        if nums[l] == target:
            return l
        return -1
