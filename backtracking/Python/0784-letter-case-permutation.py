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

    def __dfs(self, arr, size, start, res):
        if start == size:
            res.append(''.join(arr))
            return

        # 先把当前加到 pre 里面
        self.__dfs(arr, size, start + 1, res)

        # 如果是字母，就变换大小写
        if arr[start].isalpha():
            arr[start] = chr(ord(arr[start]) ^ (1 << 5))
            self.__dfs(arr, size, start + 1, res)
