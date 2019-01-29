class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        l = len(nums)
        if l < 2:
            return []
        map = dict()
        res = []
        for i in range(l):
            if nums[i] not in map:
                map[target - nums[i]] = i
            else:
                res.append(i)
                res.append(map[nums[i]])
        return res


if __name__ == '__main__':
    nums = [2, 7, 11, 15]
    target = 9
    solution = Solution()
    result = solution.twoSum(nums, target)
    print(result)
