from typing import List


class Solution:
    def minSubArrayLen(self, s: int, nums: List[int]) -> int:
        size = len(nums)
        # 特判
        if size == 0:
            return 0

        left = 0
        right = 0
        # 区间和
        interval_sum = 0
        min_len = size + 1
        while right < size:
            interval_sum += nums[right]
            right += 1

            while interval_sum >= s:
                min_len = min(min_len, right - left)
                interval_sum -= nums[left]
                left += 1
        if min_len == size + 1:
            return 0
        return min_len


if __name__ == '__main__':
    s = 7
    nums = [2, 3, 1, 2, 4, 3]
    solution = Solution()
    result = solution.minSubArrayLen(s, nums)
    print(result)
