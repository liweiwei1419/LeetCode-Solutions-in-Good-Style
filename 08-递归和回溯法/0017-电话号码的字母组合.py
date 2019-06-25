# 17. Letter Combinations of a Phone Number


class Solution:
    digits_array = [" ", "", "abc", "def", "ghi", "jkl", "mno",
                    "pqrs", "tuv", "wxyz"]

    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """

        if len(digits) == 0:
            return []
        res = []

        self.__dfs(digits, 0, '', res)
        return res

    def __dfs(self, digits, index, pre, res):
        """
        :param digits: 字母表，全局
        :param index: 当前看第几个数字
        :param pre: 已经得到的字符串
        :param res: 保存最终结果
        :return:
        """
        if index == len(digits):
            # 可以结算了
            res.append(pre)
            return
        # print(digits[index])
        # print(self.digits_array[int(digits[index])])
        s = self.digits_array[int(digits[index])]
        for alpha in s:
            self.__dfs(digits, index + 1, pre + alpha, res)


if __name__ == '__main__':
    s = Solution()
    result = s.letterCombinations('23')
    print(result)
