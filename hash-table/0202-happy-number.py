class Solution:
    def isHappy(self, n: int) -> bool:
        if n <= 0:
            return False
        # 得到一个数的每个数位
        hash_set = set()
        while True:
            square_sum = 0
            while n != 0:
                mod = n % 10
                square_sum += mod ** 2
                n = n // 10
            if square_sum == 1:
                return True
            if square_sum in hash_set:
                return False
            else:
                hash_set.add(square_sum)
                n = square_sum


if __name__ == '__main__':
    n = 19
    s = Solution()

    result = s.isHappy(n)
    print(result)
