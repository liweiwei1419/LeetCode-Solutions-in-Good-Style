from typing import List


class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        i = m - 1
        j = n - 1
        # 从后向前归并，比较 nums1 和 nums2 末尾的元素哪个大，谁大谁出列，覆盖 nums1
        for k in range(m + n - 1, -1, -1):
            # 注意：同样要把 nums1 和 nums2 归并完成的逻辑写在前面，否则会出现数组下标越界异常
            if i == -1:
                # 这里直接把 nuns2 还没看的元素复制到 nums1 即可
                # 我们可以在循环中完成，在 Java 中有更好的方法
                nums1[k] = nums2[j]
                j -= 1
            elif j == -1:
                # 注意：这里直接 break 掉就可以了
                # 因为 nums2 遍历完成以后，nums1 剩下的元素虽然还没有看，但一定是排定以后的那个样子
                break
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
