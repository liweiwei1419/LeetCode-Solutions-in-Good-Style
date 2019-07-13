from typing import List


class Solution:
    def fourSumCount(self, A: List[int], B: List[int], C: List[int], D: List[int]) -> int:
        map1 = self.__get_map(A, B)
        map2 = self.__get_map(C, D)
        res = 0

        for key1 in map1:
            if -key1 in map2:
                res += map1[key1] * map2[-key1]
        return res

    def __get_map(self, tuple1, tuple2):
        map = dict()
        for num1 in tuple1:
            for num2 in tuple2:
                map[num1 + num2] = (map.setdefault(num1 + num2, 0) + 1)
        return map
