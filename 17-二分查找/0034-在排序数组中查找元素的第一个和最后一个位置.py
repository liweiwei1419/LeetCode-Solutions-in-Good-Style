class Solution:
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        left = self.__find_lower_bound(nums, target)
        if left == -1:
            return [-1, -1]

        right = self.__find_up_bound(nums, target)
        return [left, right]

    def __find_lower_bound(self, nums, target):
        # 找到大于等于 target 的第 1 个元素的索引
        size = len(nums)
        if size == 0:
            return -1
        l = 0
        r = size - 1
        while l < r:
            mid = l + (r - l) // 2
            if nums[mid] < target:
                l = mid + 1
            else:
                assert nums[mid] >= target
                r = mid
        # 最后还要单独判断一下
        if nums[l] != target:
            return -1
        return l

    def __find_up_bound(self, nums, target):
        # 找到大于等于 target 的最后 1 个元素的索引
        size = len(nums)
        if size == 0:
            return -1
        l = 0
        r = size - 1
        while l < r:
            mid = l + (r - l + 1) // 2
            if nums[mid] > target:
                r = mid - 1
            else:
                assert nums[mid] <= target
                l = mid
        # 最后还要单独判断一下
        if nums[l] != target:
            return -1
        return l


if __name__ == '__main__':
    solution = Solution()
    nums = [5, 7, 7, 8, 8, 10]
    target = 8
    result = solution.searchRange(nums, target)
    print(result)
