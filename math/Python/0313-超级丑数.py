# 0313、超级丑数
#
# 编写一段程序来查找第 n 个超级丑数。
#
# 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。


class Solution:
    def nthSuperUglyNumber(self, n, primes):
        """
        :type n: int
        :type primes: List[int]
        :rtype: int
        """

        if n <= 0:
            return 0
        if n == 1:
            return 1
        l = len(primes)
        indexes = [0 for _ in range(l)]
        nums = [None for _ in range(n)]
        nums[0] = 1

        for i in range(1, n):
            res = float('inf')
            for j in range(l):
                res = min(res, primes[j] * nums[indexes[j]])
            nums[i] = res

            for j in range(l):
                if nums[indexes[j]] * primes[j] <= res:
                    indexes[j] += 1
        return nums[n - 1]


if __name__ == '__main__':
    n = 12
    primes = [2, 7, 13, 19]
    solution = Solution()
    result = solution.nthSuperUglyNumber(n, primes)
    print(result)
