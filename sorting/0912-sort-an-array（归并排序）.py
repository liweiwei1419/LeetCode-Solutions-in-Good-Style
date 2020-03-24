from typing import List


class Solution:

    def sortArray(self, nums: List[int]) -> List[int]:
        size = len(nums)
        temp = [0 for _ in range(size)]
        self.__merge_sort(nums, 0, size - 1, temp)
        return nums

    def __merge_sort(self, nums, left, right, temp):
        if left == right:
            return
        mid = (left + right) >> 1

        self.__merge_sort(nums, left, mid, temp)
        self.__merge_sort(nums, mid + 1, right, temp)
        self.__merge_of_two_sorted_array(nums, left, mid, right, temp)

    def __merge_of_two_sorted_array(self, nums, left, mid, right, temp):
        # [left, mid] 有序
        # [mid + 1, right] 有序
        for i in range(left, right + 1):
            temp[i] = nums[i]

        i = left
        j = mid + 1
        for k in range(left, right + 1):
            if i == mid + 1:
                nums[k] = temp[j]
                j += 1
            elif j == right + 1:
                nums[k] = temp[i]
                i += 1
            elif temp[i] <= temp[j]:
                nums[k] = temp[i]
                i += 1
            else:
                nums[k] = temp[j]
                j += 1
