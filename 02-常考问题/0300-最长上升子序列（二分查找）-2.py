from typing import List


class Solution:

    def lengthOfLIS(self, nums: List[int]) -> int:
        size = len(nums)
        # 特判
        if size < 2:
            return size
        # tail 数组的定义：长度为 i + 1 的上升子序列的末尾最小是几
        # 遍历第 1 个数，直接放在有序数组 tail 的开头
        tail = [nums[0]]
        for num in nums[1:]:
            # 找到大于等于 num 的第 1 个数，试图让它变小
            l = 0
            # 因为有可能 num 比 tail 数组中的最后一个元素还要大，
            # 【逻辑 1】所以右边界应该设置为 tail 数组的长度
            r = len(tail)
            while l < r:
                # 选左中位数不是偶然，而是有原因的，原因请见 LeetCode 第 35 题题解
                mid = l + (r - l) // 2
                if tail[mid] < num:
                    # 中位数肯定不是要找的数，把它写在分支的前面
                    l = mid + 1
                else:
                    r = mid
            if l == len(tail):
                tail.append(num)
            else:
                # 因为【逻辑 1】，因此一定能找到第 1 个大于等于 nums[i] 的元素
                # 因此，无需再单独判断，直接更新即可
                tail[l] = num
        return len(tail)
