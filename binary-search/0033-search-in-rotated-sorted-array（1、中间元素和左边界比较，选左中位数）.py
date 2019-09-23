from typing import List


class Solution:

    # 中间元素和左边界比较

    def search(self, nums: List[int], target: int) -> int:
        size = len(nums)
        if size == 0:
            return -1
        left = 0
        right = size - 1

        while left < right:
            mid = (left + right) >> 1
            if nums[left] < nums[mid]:
                # [3, 4, 5, 1, 2]
                # [left, mid] 一定是严格上升的
                if nums[left] <= target <= nums[mid]:
                    right = mid
                else:
                    left = mid + 1
            else:

                # [4, 5, 1, 2, 3]
                # [mid, right] 一定是严格上升的
                # 【特别注意】这里不能用 nums[mid] < target <= nums[right]:
                # 因为要保证看到 mid + 1 这个元素，特例 [3, 1], 1
                if nums[mid + 1] <= target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid
        return left if nums[left] == target else -1


if __name__ == '__main__':
    solution = Solution()
    nums = [3, 1]
    target = 1
    res = solution.search(nums, target)
    print(res)
