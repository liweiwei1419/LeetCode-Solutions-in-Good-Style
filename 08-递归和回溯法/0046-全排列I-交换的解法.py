class Solution:
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        l = len(nums)
        if l == 0:
            return []

        res = []
        self.helper(nums, 0, l, res)
        return res

    def helper(self, nums, begin, l, res):
        if begin == l:
            # 打开注释，看看程序是如何运行的
            # print(nums)
            res.append(nums.copy())
        for i in range(begin, l):
            nums[begin], nums[i] = nums[i], nums[begin]
            self.helper(nums, begin + 1, l, res)
            nums[begin], nums[i] = nums[i], nums[begin]


if __name__ == '__main__':
    s = Solution()
    nums = [1, 2, 3]
    result = s.permute(nums)
    print(result)
