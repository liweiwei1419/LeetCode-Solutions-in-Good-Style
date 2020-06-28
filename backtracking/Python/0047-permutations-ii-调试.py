class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        def backtrack(begin=0):
            print(nums)

            if begin == n:
                res.append(nums[:])
                return
            backtrack(begin + 1)
            for i in range(0, begin):
                if nums[i] == nums[begin]:
                    break
                nums[begin], nums[i] = nums[i], nums[begin]
                backtrack(begin + 1)
                nums[begin], nums[i] = nums[i], nums[begin]

        nums.sort()
        n = len(nums)
        res = []
        backtrack()
        return res


if __name__ == '__main__':
    s = Solution()
    nums = [1, 1,1, 3]
    result = s.permuteUnique(nums)
    print(result)