# 66. 加一
# 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
#
# 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
#
# 你可以假设除了整数 0 之外，这个整数不会以零开头。


class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """

        if len(digits) == 0:
            return []
        # 进位标识
        carry = 1

        for i in range(len(digits) - 1, -1, -1):

            s = digits[i] + carry
            digits[i] = s % 10
            # 注意：整除要使用 //
            carry = s // 10

            if carry == 0:
                return digits
        print(digits, carry)

        if carry == 1:
            return [1] + digits


if __name__ == '__main__':
    digits = [9, 9, 9, 9]
    solution = Solution()
    result = solution.plusOne(digits)
    print(result)
