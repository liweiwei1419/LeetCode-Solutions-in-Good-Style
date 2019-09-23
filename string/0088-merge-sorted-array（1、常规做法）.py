from typing import List


class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        # 只需要把 nums1 的有效个元素复制到 nums3 就可以了
        nums3 = nums1[:m]

        i = 0
        j = 0
        # 从前向后归并，比较 nums3 和 nums2 前端的元素哪个小，谁小谁出列，覆盖 nums1
        for k in range(m + n):
            # 注意：要把 nums3 和 nums2 归并完成的逻辑写在前面，否则会出现数组下标越界异常
            if i == m:
                nums1[k] = nums2[j]
                j += 1
            elif j == n:
                nums1[k] = nums3[i]
                i += 1
            elif nums3[i] < nums2[j]:
                nums1[k] = nums3[i]
                i += 1
            else:
                nums1[k] = nums2[j]
                j += 1


if __name__ == '__main__':
    nums1 = [1, 2, 3, 4, 5, 6, 7, 20, 30, 40, 50]
    nums2 = [8, 9, 10, 11, 12, 60, 70, 80]

    m = len(nums1)
    n = len(nums2)
    nums1.extend([None] * n)
    s = Solution()
    s.merge(nums1, m, nums2, n)
    print(nums1)
