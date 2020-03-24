class Solution:
    def checkPerfectNumber(self, num: int) -> bool:
        if num == 1:
            return False

        res = 1
        factor = 2
        while factor * factor < num:
            if num % factor == 0:
                res += factor
                res += num // factor
            factor += 1
        # 在上面最后一轮循环内还加了 1
        if factor * factor == num:
            res += factor
        return num == res
