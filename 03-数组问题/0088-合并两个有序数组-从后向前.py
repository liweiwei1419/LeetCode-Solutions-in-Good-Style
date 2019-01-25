# 88. 合并两个有序数组
# 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
#
# 说明:
#
# 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
# 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。


class Solution:
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: void Do not return anything, modify nums1 in-place instead.
        """

        i = m - 1
        j = n - 1

        for k in range(m + n - 1, -1, -1):
            if i == -1:  # i 用完了
                nums1[k] = nums2[j]
                j -= 1
            elif j == -1:
                nums1[k] = nums1[i]
                i -= 1
            elif nums1[i] > nums2[j]:
                nums1[k] = nums1[i]
                i -= 1
            else:
                nums1[k] = nums2[j]
                j -= 1


if __name__ == '__main__':
    nums1 = [1, 2, 3, 4, 5, 6, 7, 20, 30, 40, 50]
    nums2 = [8, 9, 10, 11, 12, 60, 70, 80]

    m = len(nums1)
    n = len(nums2)
    nums1.extend([None] * n)

    s = Solution()
    s.merge(nums1, m, nums2, n)
    print(nums1)
