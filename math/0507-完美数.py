class Solution:
    def checkPerfectNumber(self, num: int) -> bool:

        # 特判
        if num == 1:
            return False
        # 所有乘法因子的和存在这里
        res = 1
        # 可能的乘法因子，从 2 开始
        factor = 2
        while factor * factor < num:
            if num % factor == 0:
                res += factor
                res += (num // factor)
            factor += 1
        # 把中间那个数单独拿出来
        if factor * factor == num:
            res += factor
        return res == num


if __name__ == '__main__':
    solution = Solution()
    num = 28
    res = solution.checkPerfectNumber(num)
    print(res)
