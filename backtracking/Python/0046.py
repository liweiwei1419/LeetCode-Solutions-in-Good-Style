from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []

        def dfs(nums, tmp):
            print('-', nums, tmp, not nums)
            if not nums:
                res.append(tmp[:])
                return
            for i in range(len(nums)):
                tmp = tmp + [nums[i]]
                dfs(nums[:i] + nums[i + 1:], tmp)
                tmp.pop()

        dfs(nums, [])
        return res


if __name__ == '__main__':
    nums = [1, 2, 3]
    solution = Solution()
    res = solution.permute(nums)
    print(res)
