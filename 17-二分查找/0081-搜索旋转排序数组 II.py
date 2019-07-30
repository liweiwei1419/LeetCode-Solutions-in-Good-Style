from typing import List

# 中间元素和右边界比较

class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        size = len(nums)
        if size == 0:
            return False
        left = 0
        right = size - 1
        while left < right:
            # mid = left + (right - left + 1) // 2
            mid = (left + right + 1) >> 1
            if nums[mid] < nums[right]:
                # 后面是有序的
                # [2,3,4,5,5,6,6,7]
                if nums[mid] <= target <= nums[right]:
                    left = mid
                else:
                    right = mid - 1
            elif nums[mid] > nums[right]:
                # [3,4,5,5,6,6,7,2]
                if nums[left] <= target <= nums[mid - 1]:
                    right = mid - 1
                else:
                    left = mid
            else:
                assert nums[mid] == nums[right]
                if nums[right] == target:
                    return True
                # 右边不是才删除
                right = right - 1
        # 后处理
        return nums[left] == target


if __name__ == '__main__':
    nums = [3, 1]
    target = 1
    solution = Solution()

    result = solution.search(nums, target)
    print(result)
