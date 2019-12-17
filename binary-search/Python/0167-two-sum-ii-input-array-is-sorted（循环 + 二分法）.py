from typing import List


class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        size = len(numbers)
        for left in range(size - 1):
            right = self.__binary_search(numbers, left + 1, size - 1, target - numbers[left])
            if right != -1:
                return [left + 1, right + 1]

    def __binary_search(self, numbers, left, right, target):
        # 在子区间 [left, right] 找 target
        while left < right:
            mid = (left + right) >> 1
            if numbers[mid] < target:
                left = mid + 1
            else:
                right = mid
        return left if numbers[left] == target else -1


if __name__ == '__main__':
    numbers = [2, 7, 11, 15]
    target = 9

    solution = Solution()
    res = solution.twoSum(numbers, target)
    print(res)
