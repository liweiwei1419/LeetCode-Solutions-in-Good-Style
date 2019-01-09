class Solution:
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        result = []
        # 去重
        s = set(nums1)
        for num in nums2:
            if num in s:
                result.append(num)
                # 发现一样的元素以后，就从 set 里删除，可以避免重复
                s.remove(num)
        return result


if __name__ == '__main__':
    nums1 = [4, 9, 5]
    nums2 = [9, 4, 9, 8, 4]
    s = Solution()
    result = s.intersection(nums1, nums2)
    print(result)
