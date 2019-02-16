class Solution:
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: List[str]
        """

        size = len(s)

        if size == 0:
            return None

        word_set = set(wordDict)

        # dp[i] 表示长度为 i 的 s，满足题意
        # 0 表示 False ，1 表示 True
        dp = [0 for _ in range(size + 1)]
        dp[0] = 1

        for i in range(1, size + 1):
            # i 表示 s 子串的长度
            for j in range(i):
                # j 表示后子串的起始位置，最多到 i-1
                # j 也正正好表示前子串的长度
                if s[j:i] in word_set and dp[j]:
                    dp[i] = 1

        res = []
        if dp[-1]:
            self.__dfs(s, size, wordDict, res, [], dp)
        return res

    def __dfs(self, s, length, wordDict, res, path, dp):

        if length == 0:
            res.append(' '.join(reversed(path)))
            return

        for i in range(length):
            cur = s[i:length]

            if dp[i] and cur in wordDict:
                path.append(cur)
                self.__dfs(s, i, wordDict, res, path, dp)
                path.pop()


if __name__ == '__main__':
    s = "pineapplepenapple"
    wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
    solution = Solution()
    result = solution.wordBreak(s, wordDict)
    print(result)
