from typing import List


class Solution:
    def letterCasePermutation(self, S: str) -> List[str]:
        size = len(S)

        if size == 0:
            return []

        res = []
        arr = list(S)
        self.__dfs(arr, size, 0, res)
        return res

    def __dfs(self, arr, size, index, res):
        if index == size:
            return res.append(''.join(arr))

        # 先把当前加到 pre 里面
        self.__dfs(arr, size, index + 1, res)

        # 如果是字母，就变换大小写
        if arr[index].isalpha():
            arr[index] = chr(ord(arr[index]) ^ (1 << 5))
            self.__dfs(arr, size, index + 1, res)


if __name__ == '__main__':
    solution = Solution()
    S = 'a1b2'
    res = solution.letterCasePermutation(S)
    print(res)
