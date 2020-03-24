from typing import List
import random


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        size = len(nums)

        target = size - k
        left = 0
        right = size - 1
        while True:
            index = self.__partition(nums, left, right)
            if index == target:
                return nums[index]
            elif index < target:
                # 下一轮在 [index + 1, right] 里找
                left = index + 1
            else:
                right = index - 1

    # 循环不变量：
    # [left + 1, lt） <= pivot
    # (rt, right] >= pivot
    def __partition(self, nums, left, right):
        # randint 是包括左右区间的
        random_index = random.randint(left, right)
        nums[random_index], nums[left] = nums[left], nums[random_index]

        pivot = nums[left]

        lt = left + 1
        rt = right

        while True:
            while lt <= rt and nums[lt] < pivot:
                lt += 1
            while lt <= rt and nums[rt] > pivot:
                rt -= 1

            if lt > rt:
                break
            nums[lt], nums[rt] = nums[rt], nums[lt]
            lt += 1
            rt -= 1

        nums[left], nums[rt] = nums[rt], nums[left]
        return rt
