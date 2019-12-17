from typing import List


class Solution:

    # 中间元素和右边界比较

    def search(self, nums: List[int], target: int) -> int:
        size = len(nums)
        if size == 0:
            return -1

        left = 0
        right = size - 1
        while left < right:
            mid = (left + right + 1) >> 1
            if nums[mid] < nums[right]:
                # [7, 8, 1, 2, 3] ，后半部分有序
                if nums[mid] <= target <= nums[right]:
                    left = mid
                else:
                    right = mid - 1
            else:
                # [4, 5, 6, 1, 2]，前半部分有序
                if nums[left] <= target <= nums[mid - 1]:
                    right = mid - 1
                else:
                    left = mid
        # 后处理
        return left if nums[left] == target else -1


if __name__ == '__main__':
    nums = [4, 5, 6, 7, 0, 1, 2]
    target = 0
    solution = Solution()

    result = solution.search(nums, target)
    print(result)
