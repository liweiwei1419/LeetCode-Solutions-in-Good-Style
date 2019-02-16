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

        # 既然是求最小的长度，初始值应该设置成一个不可能达到的上限
        res = size + 1
        cur_sum = 0
        for i in range(size):
            cur_sum += nums[i]
            # 此时 cur_sum >= s
            while cur_sum >= s:
                res = min(res, i - l + 1)
                cur_sum -= nums[l]
                l += 1
        # 如果全部数组元素加起来都 < s ，即 res 的值没有被更新，根据题意返回 0
        if res == len(nums) + 1:
            return 0
        return res


if __name__ == '__main__':
    s = 7
    nums = [2, 3, 1, 2, 4, 3]
    solution = Solution()
    result = solution.minSubArrayLen(s, nums)
    print(result)
