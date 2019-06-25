# 17. Letter Combinations of a Phone Number
# 比上一个版本多了打印的输出，用于调试


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
            print("已经从根节点走到叶子节点，得到的一个组合是：" + pre);
            print();
            res.append(pre)
            return

        s = self.digits_array[int(digits[index])]
        for alpha in s:
            print("当前的索引是：", index, "，已经得到的字符串是：", pre)
            self.__dfs(digits, index + 1, pre + alpha, res)


if __name__ == '__main__':
    s = Solution()
    result = s.letterCombinations('234')
    print(result)
