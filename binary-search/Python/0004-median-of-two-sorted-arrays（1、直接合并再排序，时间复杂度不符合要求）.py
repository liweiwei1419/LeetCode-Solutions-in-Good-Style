from typing import List


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m = len(nums1)
        n = len(nums2)
        nums1.extend(nums2)

        nums1.sort()

        if (m + n) & 1:
            return nums1[(m + n - 1) >> 1]
        else:
            return (nums1[(m + n - 1) >> 1] + nums1[(m + n) >> 1]) / 2


if __name__ == '__main__':
    nums1 = [1, 3]
    nums2 = [2]

    solution = Solution()
    res = solution.findMedianSortedArrays(nums1, nums2)
    print(res)
