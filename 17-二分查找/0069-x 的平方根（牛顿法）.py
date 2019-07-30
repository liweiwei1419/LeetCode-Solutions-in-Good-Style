class Solution:
    def mySqrt(self, x: int) -> int:
        if x < 0:
            raise Exception('不能输入负数')
        if x == 0:
            return 0

        # 把上一轮迭代的值设置成一个很大的值，是为了保证一开始的时候误差足够大
        pre = float('inf')
        # 初值选正数，否则会得到负数的平方根，不符合题目要求
        cur = 1

        # 当迭代变化比较大的时候，才有必要继续迭代
        while abs(cur - pre) > 1e-6:
            # 先把上一轮迭代的值记录一下，用于比较是否收敛
            pre = cur
            # 根据上一轮迭代的值计算这一次迭代的值
            cur = (pre + x / pre) / 2

        return int(cur)


if __name__ == '__main__':
    solution = Solution()
    x = 7
    res = solution.mySqrt(x)
    print(res)
