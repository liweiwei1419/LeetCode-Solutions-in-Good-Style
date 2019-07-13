from typing import List


class Solution:

    # 返回的是大于等于 target 的索引，有可能是最后一个

    def searchInsert(self, nums: List[int], target: int) -> int:
        length = len(nums)
        left = 0
        # 修改 1：如果 target 比数组的最后一个元素还要大，那么插入的位置就应该是 length，因此右边界应该为 length
        right = length
        while left < right:

            # 修改 4：根据下面两个分支的逻辑，应该选左中位数，如果选右中位数，右边界不更新的话，会陷入死循环
            # 以下代码各选一行都是可以的，没有被我注释的那一行代码更优
            # mid = left + (right - left) // 2
            mid = (left + right) >> 1

            # 修改 2：（理解这里很关键，根据题意）这里应该加等于号，结合题目意思，nums[mid] > target 的时候，mid 有可能就是要定位的索引
            # 因此不能把 mid 排除，并且还要把 target == nums[mid] 的情况归到这个分支来
            if target <= nums[mid]:
                right = mid
            else:
                # 修改 3：当 nums[mid] < target 的时候，因为我们要找的是第 1 个大于等于 target 的索引，因此 mid 肯定不是所求，故左边界是 mid + 1
                assert target > nums[mid]
                left = mid + 1
        return left


if __name__ == '__main__':
    nums = [1, 3, 5, 6]
    target = 5
    solution = Solution()
    result = solution.searchInsert(nums, target)
    print(result)
