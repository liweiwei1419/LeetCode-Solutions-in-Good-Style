from typing import List
from collections import deque


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        size = len(s)

        # 题目中说非空字符串，以下 assert 一定通过
        assert size > 0

        # 预处理，把 wordDict 放进一个哈希表中
        word_set = {word for word in wordDict}

        # dp[i] 表示长度为 i 的 s，满足题意
        # 0 表示 False ，1 表示 True
        dp = [0 for _ in range(size + 1)]
        dp[0] = 1

        for i in range(1, size + 1):
            # i 表示 s 子串的长度
            for j in range(i):
                # j 表示后子串的起始位置，最多到 i-1
                # j 也正正好表示前子串的长度
                # dp[j] 写在前面会更快一点，否则还要去切片，然后再放入 hash 表判重
                if dp[j] and s[j:i] in word_set:
                    dp[i] = 1
                    break

        res = []
        # 如果有解，才有必要回溯
        if dp[-1]:
            queue = deque()
            self.__dfs(s, size, word_set, res, queue, dp)
        return res

    def __dfs(self, s, length, word_set, res, path, dp):
        if length == 0:
            res.append(' '.join(path))
            return
        for i in range(length):
            if dp[i]:
                suffix = s[i:length]
                if suffix in word_set:
                    path.appendleft(suffix)
                    self.__dfs(s, i, word_set, res, path, dp)
                    path.popleft()


if __name__ == '__main__':
    s = "pineapplepenapple"
    wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
    solution = Solution()
    result = solution.wordBreak(s, wordDict)
    print(result)
