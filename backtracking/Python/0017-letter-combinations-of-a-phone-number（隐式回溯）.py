from typing import List


class Solution:
    # 隐式回溯，字符串产生新对象

    digits_array = [" ", "", "abc", "def", "ghi", "jkl", "mno",
                    "pqrs", "tuv", "wxyz"]

    def letterCombinations(self, digits: str) -> List[str]:
        size = len(digits)
        if size == 0:
            return []
        res = []

        self.__dfs(digits, 0, size, '', res)
        return res

    def __dfs(self, digits, index, size, pre, res):
        """
        :param digits: 字母表，全局
        :param index: 当前看第几个数字
        :param size: 一共几个数字
        :param pre: 已经得到的字符串
        :param res: 保存最终结果
        :return:
        """
        if index == len(digits):
            res.append(pre)
            return
        s = self.digits_array[int(digits[index])]
        for alpha in s:
            self.__dfs(digits, index + 1, size, pre + alpha, res)


if __name__ == '__main__':
    s = Solution()
    result = s.letterCombinations('23')
    print(result)
