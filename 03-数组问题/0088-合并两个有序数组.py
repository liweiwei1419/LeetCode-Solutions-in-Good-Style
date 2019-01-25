class Solution:
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: void Do not return anything, modify nums1 in-place instead.
        """
        nums3 = nums1[:]

        i = 0
        j = 0

        for k in range(m + n):
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
