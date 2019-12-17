from typing import List


class Solution:
    def minSubArrayLen(self, s: int, nums: List[int]) -> int:
        # 滑动窗口
        size = len(nums)
        # 特判
        if size == 0:
            return 0

        left = 0

        # 既然是求最小的长度，初始值应该设置成一个不可能达到的上限
        res = size + 1
        cur_sum = 0
        for right in range(size):
            cur_sum += nums[right]
            # 此时 cur_sum >= s
            while cur_sum >= s:
                res = min(res, right - left + 1)
                cur_sum -= nums[left]
                left += 1
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
