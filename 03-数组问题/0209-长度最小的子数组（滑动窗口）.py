class Solution:
    def minSubArrayLen(self, s, nums):
        """
        :type s: int
        :type nums: List[int]
        :rtype: int
        """
        # 滑动窗口
        size = len(nums)
        # 特判
        if size == 0:
            return 0

        l = 0
        r = -1
        sum = 0
        res = size + 1
        while l < size:
            if r + 1 < size and sum < s:
                r += 1
                sum += nums[r]
            else:
                sum -= nums[l]
                l += 1
            if sum >= s:
                res = min(res, r - l + 1)
        if res == size + 1:
            return 0
        return res


if __name__ == '__main__':
    s = 7
    nums = [2, 3, 1, 2, 4, 3]
    solution = Solution()
    result = solution.minSubArrayLen(s, nums)
    print(result)
