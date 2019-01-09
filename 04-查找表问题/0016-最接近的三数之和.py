class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """

        if len(nums) < 3:
            return []
        # 初始化
        diff = float('inf')
        nums.sort()
        for index in range(len(nums) - 2):
            if index > 0 and nums[index] == nums[index - 1]:
                continue
            l = index + 1
            r = len(nums) - 1
            while l < r:
                s = nums[index] + nums[l] + nums[r]
                if abs(s - target) < diff:
                    diff = abs(s - target)
                    res = s
                if s > target:
                    r -= 1
                elif s < target:
                    l += 1
                else:
                    return target
        return res


if __name__ == '__main__':
    nums = [-1, 0, 1, 1, 55]
    target = 3
    solution = Solution()
    result = solution.threeSumClosest(nums, target)
    print(result)
