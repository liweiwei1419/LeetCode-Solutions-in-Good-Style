from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        size = len(nums)
        # 特判
        if size < 2:
            return size

        # 为了防止后序逻辑发生数组索引越界，先把第 1 个数放进去
        tail = [nums[0]]
        for num in nums[1:]:
            # 【逻辑 1】比 tail 数组实际有效的末尾的那个元素还大
            # 先尝试是否可以接在末尾
            if num > tail[-1]:
                tail.append(num)
                continue

            # 使用二分查找法，在有序数组 tail 中
            # 找到第 1 个大于等于 nums[i] 的元素，尝试让那个元素更小
            l = 0
            r = len(tail) - 1
            while l < r:
                # 选左中位数不是偶然，而是有原因的，原因请见 LeetCode 第 35 题题解
                # mid = l + (r - l) // 2
                mid = l + ((r - l) >> 1)
                if tail[mid] < num:
                    # 中位数肯定不是要找的数，把它写在分支的前面
                    l = mid + 1
                else:
                    r = mid
            # 走到这里是因为【逻辑 1】的反面，因此一定能找到第 1 个大于等于 nums[i] 的元素
            # 因此，无需再单独判断
            tail[l] = num
        return len(tail)


def binary_search_1(l, r):
    # 当分支逻辑不能排除右边界的时候选择左中位数
    # 如果选择右中位数，当区间只剩下 2 个元素的时候，
    # 一旦进入 r = mid 这个分支，右边界不会收缩，代码进入死循环
    while l < r:
        mid = l + (r - l) // 2
        if check(mid):
            # 先写可以排除中位数的逻辑
            l = mid + 1
        else:
            r = mid


def binary_search_2(l, r):
    # 当分支逻辑不能排除左边界的时候选择右中位数
    # 如果选择左中位数，当区间只剩下 2 个元素的时候，
    # 一旦进入 l = mid 这个分支，左边界不会收缩，代码进入死循环
    while l < r:
        mid = l + (r - l + 1) // 2
        if check(mid):
            # 先写可以排除中位数的逻辑
            r = mid - 1
        else:
            l = mid
