from typing import List


class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        size = len(nums)

        temp = nums[:]

        # 根据每个元素值的范围
        # -50000 <= A[i] <= 50000
        M = 100000
        counter = [0] * M

        for num in temp:
            counter[num + 50000] += 1

        # 变成前缀和数组
        for i in range(1, M):
            counter[i] += counter[i - 1]

        # 从后向前赋值回去
        for i in range(size - 1, - 1, -1):
            counter[temp[i] + 50000] -= 1
            nums[counter[temp[i] + 50000]] = temp[i]
        return nums
