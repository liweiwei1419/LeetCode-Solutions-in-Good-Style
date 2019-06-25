class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        size = len(nums)
        l = 1
        r = size - 1

        while l < r:
            mid = l + (r - l ) // 2

            counter = 0
            for num in nums:
                if num <= mid:
                    counter += 1

            # 小于等于 mid 的数如果多于 mid，重复的数就一定在 mid 里面

            if counter > mid:
                r = mid
            else:
                l = mid + 1

        return l
