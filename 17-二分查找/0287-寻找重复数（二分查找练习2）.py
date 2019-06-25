class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        size = len(nums)
        l = 1
        r = size - 1

        while l < r:
            mid = l + (r - l + 1) // 2

            counter = 0
            for num in nums:
                if num < mid:
                    counter += 1

            if counter >= mid:
                # 如果小于 4 的个数等于 4 或者更多
                # 那么重复的数一定位于 1、2、3
                r = mid - 1
            else:
                l = mid

        return l
