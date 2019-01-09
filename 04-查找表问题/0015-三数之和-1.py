class Solution(object):
    # 排序可以去掉 -4 但是不能把后面重复的 2 去掉
    # [-4,-4,2,2]
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if len(nums) < 3:
            return []
        nums.sort()

        if nums[0] == nums[-1] == 0:
            return [[0, 0, 0]]

        res = set()
        # 最后两个数就没有必要作为遍历的起点了
        for index, one in enumerate(nums[:-2]):
            # 因为题目要求，答案中不可以包含重复的三元组。
            if index >= 1 and nums[index] == nums[index - 1]:
                continue
            s = set()
            for two in nums[index + 1:]:
                if two not in s:
                    s.add(-one - two)
                else:
                    # 找到了一个解
                    res.add((one, two, -one - two))
        return list(map(list, res))


if __name__ == '__main__':
    nums = [-2, 0, 0, 2, 2]
    solution = Solution()
    result = solution.threeSum(nums)
    print(result)