from typing import List


class Solution:
    # 比上一个版本多了打印的输出，用于调试
    digits_array = [" ", "", "abc", "def", "ghi", "jkl", "mno",
                    "pqrs", "tuv", "wxyz"]

    def letterCombinations(self, digits: str) -> List[str]:
        size = len(digits)
        if size == 0:
            return []
        res = []
        self.__dfs(digits, 0, size, [], res)
        return res

    def __dfs(self, digits, index, size, pre, res):
        if index == len(digits):
            print("已经从根节点走到叶子节点，得到的一个组合是：" + ''.join(pre))
            print()
            res.append(''.join(pre))
            return

        s = self.digits_array[int(digits[index])]
        for alpha in s:
            print("当前的索引是：", index, "，已经得到的字符串是：", pre)
            pre.append(alpha)
            self.__dfs(digits, index + 1, size, pre, res)
            pre.pop()


if __name__ == '__main__':
    s = Solution()
    result = s.letterCombinations('234')
    print(result)
