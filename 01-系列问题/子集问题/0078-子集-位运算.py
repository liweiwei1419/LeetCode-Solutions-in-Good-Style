class Solution:

    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        size = len(nums)
        n = 1 << size

        res = []

        for i in range(n):
            cur = []
            for j in range(size):
                if i >> j & 1 != 0:
                    cur.append(nums[j])
            # print(i, bin(i), cur)
            res.append(cur)
        return res

if __name__ == '__main__':
    nums = [1, 2, 3]
    solution = Solution()
    result = solution.subsets(nums)
    print(result)
