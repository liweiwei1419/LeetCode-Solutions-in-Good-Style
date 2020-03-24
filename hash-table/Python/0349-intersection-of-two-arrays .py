from typing import List

class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        res = []
        # 去重
        hash_set = set(nums1)
        for num in nums2:
            if num in hash_set:
                res.append(num)
                # 发现一样的元素以后，就从 set 里删除，可以避免重复
                hash_set.remove(num)
        return res


if __name__ == '__main__':
    nums1 = [4, 9, 5]
    nums2 = [9, 4, 9, 8, 4]
    s = Solution()
    result = s.intersection(nums1, nums2)
    print(result)
