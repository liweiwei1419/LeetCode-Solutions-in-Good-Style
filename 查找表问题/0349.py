class Solution:

    # 求出两个数组的交集

    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        # 让 num1 是元素多的那个数组
        if len(nums1) == len(nums2):
            nums1, nums2 = nums2, nums1
        s = set(nums1)
        return list({x for x in nums2 if x in s})


if __name__ == '__main__':
    solution = Solution()
    nums1 = [1, 2, 2, 1]
    nums2 = [2, 2]
    result = solution.intersection(nums1, nums2)
    print(result)
