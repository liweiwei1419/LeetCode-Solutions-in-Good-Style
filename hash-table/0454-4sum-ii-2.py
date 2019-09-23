from typing import List


class Solution:
    def fourSumCount(self, A: List[int], B: List[int], C: List[int], D: List[int]) -> int:
        hash_map = dict()
        for num3 in C:
            for num4 in D:
                hash_map[num3 + num4] = (hash_map.setdefault(num3 + num4, 0) + 1)

        res = 0
        for num1 in A:
            for num2 in B:
                s = num1 + num2
                if -s in hash_map:
                    res += hash_map[-s]
        return res
