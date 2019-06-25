# 264、丑数的顺序
# 编写一个程序，找出第 n 个丑数。
#
# 丑数就是只包含质因数 2, 3, 5 的正整数。
#
# 示例:
#
# 输入: n = 10
# 输出: 12
# 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。


class Solution:
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 0:
            return 0
        if n == 1:
            return 1

        # 索引从 0 开始
        M2 = 0
        M3 = 0
        M5 = 0
        nums = [None for _ in range(n)]
        nums[0] = 1
        for index in range(1, n):
            nums[index] = min(nums[M2] * 2, nums[M3] * 3, nums[M5] * 5)
            while nums[M2] * 2 <= nums[index]:
                M2 += 1
            while nums[M3] * 3 <= nums[index]:
                M3 += 1
            while nums[M5] * 5 <= nums[index]:
                M5 += 1
        return nums[n - 1]


if __name__ == '__main__':
    n = 10
    solution = Solution()
    result = solution.nthUglyNumber(n)
    print(result)
