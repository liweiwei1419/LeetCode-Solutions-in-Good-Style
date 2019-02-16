# 12. 整数转罗马数字
# 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
# 整形转罗马数字
class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        nums = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
        romans = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"]
        index = 0
        res = ''
        while index < 13:
            # 注意：这里是等于号
            while num >= nums[index]:
                res += romans[index]
                num -= nums[index]
            index += 1
        return res


if __name__ == '__main__':
    s = Solution()
    num = 3
    result = s.intToRoman(num)
    print(result)
