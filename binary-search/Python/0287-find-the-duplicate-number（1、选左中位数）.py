from typing import List


class Solution:
    def findDuplicate(self, nums: List[int]) -> int:

        left = 1
        right = len(nums) - 1

        while left < right:
            mid = (left + right) >> 1
            count = 0
            for num in nums:
                if num <= mid:
                    count += 1
            if count <= mid:
                # 在 [left, mid] 这个区间没有重复元素，因此搜索范围在 [mid + 1, right]
                left = mid + 1
            else:
                # 在 [left, mid] 这个区间有重复元素，因此搜索范围在 [left, mid]
                right = mid
        # 退出循环的时候 left == right 为 True
        return left


if __name__ == '__main__':
    nums = [1, 3, 4, 2, 2]
    solution = Solution()
    result = solution.findDuplicate(nums)
    print(result)
