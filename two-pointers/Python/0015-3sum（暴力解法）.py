from typing import List


class Solution:

    # 暴力解法：去重复是一个问题

    def threeSum(self, nums: List[int]) -> List[List[int]]:
        size = len(nums)
        res = []
        if size < 3:
            return res

        for i in range(size - 2):
            for j in range(i + 1, size - 1):
                for k in range(j + 1, size):
                    if nums[i] + nums[j] + nums[k] == 0:
                        res.append([nums[i], nums[j], nums[k]])

        return res


if __name__ == '__main__':
    nums = [-2, 0, 0, 2, 2]
    solution = Solution()
    result = solution.threeSum(nums)
    print(result)
