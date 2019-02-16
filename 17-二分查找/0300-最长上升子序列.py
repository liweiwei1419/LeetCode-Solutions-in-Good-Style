class Solution:
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        size = len(nums)
        if size < 2:
            return size
        # 最长上升子序列
        lis = []
        for num in nums:
            # 找到大于等于 num 的第 1 个数
            l = 0
            # 因为有可能新加的这个数，比之前所有的数都大，所以右边界是当前 lis 的长度
            r = len(lis)
            while l < r:
                mid = l + (r - l) // 2
                if lis[mid] >= num:
                    r = mid
                else:
                    l = mid + 1
            if l == len(lis):
                lis.append(num)
            else:
                # 大于等于 num 的第 1 个数变小
                # 这样后面才有可能接上更多的数，是贪心算法的思想
                lis[l] = num
        return len(lis)


if __name__ == '__main__':
    nums = [10, 9, 2, 5, 3, 7, 101, 18]
    solution = Solution()
    result = solution.lengthOfLIS(nums)
    print(result)
