from typing import List


class Solution:
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
            res.append(''.join(pre))
            return
        s = self.digits_array[int(digits[index])]
        for alpha in s:
            pre.append(alpha)
            self.__dfs(digits, index + 1, size, pre, res)
            pre.pop()


if __name__ == '__main__':
    s = Solution()
    result = s.letterCombinations('23')
    print(result)
