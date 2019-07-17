from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) < 2:
            return len(nums)

        i = 0
        res = []

        while i < len(nums) - 1:
            if nums[i] != nums[i + 1]:
                res.append(nums[i])
            i += 1
        res.append(nums[i])

        for i in range(len(res)):
            nums[i] = res[i]
        return len(res)


if __name__ == '__main__':
    s = Solution()
    nums = [1, 1, 2]
    res = s.removeDuplicates(nums)
    print(nums)
    print(res)
