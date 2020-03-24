from typing import List

class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        return list({x for x in nums2 if x in nums1})


if __name__ == '__main__':
    s = [1, 2, 3, 4]
    print(1 in s)
