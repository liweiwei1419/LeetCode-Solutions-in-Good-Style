class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        nums1.sort()
        nums2.sort()
        p1 = 0
        p2 = 0
        l1 = len(nums1)
        l2 = len(nums2)
        result = []
        while p1 < l1 and p2 < l2:
            if nums1[p1] < nums2[p2]:
                p1 += 1
            elif nums1[p1] > nums2[p2]:
                p2 += 1
            else:
                result.append(nums1[p1])
                p1 += 1
                p2 += 1
        return result


if __name__ == '__main__':
    nums1 = [1, 2, 2, 1]
    nums2 = [2, 2]
    solution = Solution()
    result = solution.intersect(nums1, nums2)
    print(result)
