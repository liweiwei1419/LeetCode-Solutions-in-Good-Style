class Solution:
    def fourSumCount(self, A, B, C, D):
        """
        :type A: List[int]
        :type B: List[int]
        :type C: List[int]
        :type D: List[int]
        :rtype: int
        """

        map = dict()
        for num3 in C:
            for num4 in D:
                map[num3 + num4] = (map.setdefault(num3 + num4, 0) + 1)

        res = 0

        for num1 in A:
            for num2 in B:
                s = num1 + num2
                if -s in map:
                    res += map[-s]
        return res
