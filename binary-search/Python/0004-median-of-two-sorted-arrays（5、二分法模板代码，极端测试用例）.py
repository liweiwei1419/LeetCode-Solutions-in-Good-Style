from typing import List


class Solution:

    # 调试使用，不能正确运行

    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        # if len(nums1) > len(nums2):
        #     nums1, nums2 = nums2, nums1

        m = len(nums1)
        n = len(nums2)

        left = 0
        right = m

        left_total = (m + n + 1) >> 1
        while left < right:
            i = (left + right) >> 1
            j = left_total - i

            print('i = {}, j = {}'.format(i, j))
            if nums2[j - 1] > nums1[i]:
                left = i + 1
            else:
                right = i

        i = left
        j = left_total - left

        nums1_left_max = float('-inf') if i == 0 else nums1[i - 1]
        nums1_right_min = float('inf') if i == m else nums1[i]

        nums2_left_max = float('-inf') if j == 0 else nums2[j - 1]
        nums2_right_min = float('inf') if j == n else nums2[j]

        if (m + n) & 1:
            return max(nums1_left_max, nums2_left_max)
        else:
            return (max(nums1_left_max, nums2_left_max) + min(nums1_right_min, nums2_right_min)) / 2


if __name__ == '__main__':
    nums1 = [1, 2, 3, 4, 5, 7, 8, 9, 10]
    nums2 = [6]

    solution = Solution()
    res = solution.findMedianSortedArrays(nums1, nums2)
    print(res)
