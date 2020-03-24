class Solution(object):
    def hammingWeight(self, n):
        n = n & 0xFFFFFFFF
        res = 0
        while n:
            n = n & (n - 1)
            res += 1
        return res
