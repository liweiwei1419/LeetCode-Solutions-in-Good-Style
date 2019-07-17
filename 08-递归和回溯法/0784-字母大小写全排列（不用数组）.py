from typing import List


class Solution:
    def letterCasePermutation(self, S: str) -> List[str]:
        size = len(S)

        if size == 0:
            return []

        res = []
        path = []
        self.__dfs(S, size, 0, path, res)
        return res

    def __dfs(self, S, size, index, path, res):
        if index == size:
            return res.append(''.join(path))

        path.append(S[index])
        self.__dfs(S, size, index + 1, path, res)
        path.pop()

        # 如果是字母，就变换大小写
        if S[index].isalpha():
            path.append(chr(ord(S[index]) ^ (1 << 5)))
            self.__dfs(S, size, index + 1, path, res)
            path.pop()



if __name__ == '__main__':
    solution = Solution()
    S = 'a1b2'
    res = solution.letterCasePermutation(S)
    print(res)
