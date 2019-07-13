from typing import List


class Solution:

    # 排序可以去掉 -4 但是不能把后面重复的 2 去掉
    # [-4,-4,2,2]
    def threeSum(self, nums: List[int]) -> List[List[int]]:

        size = len(nums)
        if size < 3:
            return []
        nums.sort()

        # 特判
        if nums[0] == nums[-1] == 0:
            return [[0, 0, 0]]

        # 判重
        res = set()
        # 最后两个数就没有必要作为遍历的起点了
        for i in range(size - 2):
            # 因为题目要求，答案中不可以包含重复的三元组
            # 这一步是常见的剪枝操作
            if i >= 1 and nums[i] == nums[i - 1]:
                continue
            s = set()

            for j in range(i + 1, size):
                if nums[j] not in s:
                    s.add(-nums[i] - nums[j])
                else:
                    # 找到了一个解
                    res.add((nums[i], nums[j], -nums[i] - nums[j]))
        return list(map(list, res))


if __name__ == '__main__':
    nums = [-2, 0, 0, 2, 2]
    solution = Solution()
    result = solution.threeSum(nums)
    print(result)
