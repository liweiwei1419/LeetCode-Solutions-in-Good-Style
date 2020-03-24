from typing import List


class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # 让 num1 是元素多的那个数组
        if len(nums1) == len(nums2):
            nums1, nums2 = nums2, nums1
        # 去重复
        s = set(nums1)
        # 这一步在 nums2 里面的操作就变少了
        return list({x for x in nums2 if x in s})


# 解法2：
# return list(set(nums1) & set(nums2))

# 解法3：
# return list(set(nums1).intersection(set(nums2)))

# 解法4：
# nums1 = set(nums1)
# nums2 = set(nums2)
# return list(nums1 & nums2)


if __name__ == '__main__':
    solution = Solution()
    nums1 = [1, 2, 2, 1]
    nums2 = [2, 2]
    result = solution.intersection(nums1, nums2)
    print(result)
