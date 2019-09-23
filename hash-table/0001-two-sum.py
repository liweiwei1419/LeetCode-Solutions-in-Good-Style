from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        size = len(nums)
        if size < 2:
            return []
        hash = dict()
        res = []
        for i in range(size):
            if nums[i] not in hash:
                hash[target - nums[i]] = i
            else:
                res.append(i)
                res.append(hash[nums[i]])
        return res


if __name__ == '__main__':
    nums = [2, 7, 11, 15]
    target = 9
    solution = Solution()
    result = solution.twoSum(nums, target)
    print(result)
