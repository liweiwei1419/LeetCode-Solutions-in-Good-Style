from typing import List


class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        left = 1
        right = len(nums) - 1

        while left < right:
            mid = (left + right + 1) >> 1
            count = 0
            for num in nums:
                if num < mid:
                    count += 1

            if count < mid:
                # 比 4 小的个数，最多就只能是 3，因此重复的肯定不是 [1,2,3]
                # 因为左边不变，所以取中点的时候，就要偏右
                left = mid
            else:
                # 比 4 小的个数，达到 4 或者更多，重复的就落在 [1, 2, 3]
                right = mid - 1
        return left


if __name__ == '__main__':
    nums = [3, 1, 3, 4, 2]
    solution = Solution()
    result = solution.findDuplicate(nums)
    print(result)