class Solution:
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """

        while True:
            # 当前这个数字的每个数位之和
            sum_num = 0
            while num != 0:
                sum_num += num % 10
                num = num // 10

            if sum_num < 10:
                return sum_num
            else:
                num = sum_num


if __name__ == '__main__':
    num = 38
    s = Solution()

    result = s.addDigits(num)
    print(result)
