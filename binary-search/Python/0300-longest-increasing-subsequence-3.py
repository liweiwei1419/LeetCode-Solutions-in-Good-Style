from typing import List


class Solution:

    def lengthOfLIS(self, nums: List[int]) -> int:
        size = len(nums)
        if size < 2:
            return size
        # 最长上升子序列
        tail = []
        for num in nums:
            # 找到大于等于 num 的第 1 个数
            left = 0
            # 因为有可能新加的这个数，比之前所有的数都大，所以右边界是当前 tail 的长度
            right = len(tail)
            while left < right:
                mid = (left + right) >> 1
                if tail[mid] >= num:
                    right = mid
                else:
                    left = mid + 1
            if left == len(tail):
                tail.append(num)
            else:
                # 大于等于 num 的第 1 个数变小
                # 这样后面才有可能接上更多的数，是贪心算法的思想
                tail[left] = num
        return len(tail)


if __name__ == '__main__':
    nums = [10, 9, 2, 5, 3, 7, 101, 18]
    solution = Solution()
    result = solution.lengthOfLIS(nums)
    print(result)
