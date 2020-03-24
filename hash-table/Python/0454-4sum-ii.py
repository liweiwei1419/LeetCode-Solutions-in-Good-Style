from typing import List


class Solution:
    def fourSumCount(self, A: List[int], B: List[int], C: List[int], D: List[int]) -> int:
        hash_map1 = self.__get_map(A, B)
        hash_map2 = self.__get_map(C, D)
        res = 0

        for key1 in hash_map1:
            if -key1 in hash_map2:
                res += hash_map1[key1] * hash_map2[-key1]
        return res

    def __get_map(self, tuple1, tuple2):
        hash_map = dict()
        for num1 in tuple1:
            for num2 in tuple2:
                hash_map[num1 + num2] = (hash_map.setdefault(num1 + num2, 0) + 1)
        return hash_map
