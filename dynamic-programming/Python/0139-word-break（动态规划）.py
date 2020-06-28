from typing import List


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        size = len(s)
        word_set = set(wordDict)
        # dp[i]：长度为 i 的 s 字符串经过空格分隔以后在 wordDict 中
        # 需要长度为 0，因此前面加上一个 True
        # 特例：整个字符串恰好就在 wordDict 中
        dp = [True] + [False for _ in range(size)]
        for i in range(1, size + 1):
            # j 其实就是前缀的长度，注意这个细节
            for j in range(i):
                right = s[j:i]
                if right in word_set and dp[j]:
                    dp[i] = True
                    break
        return dp[-1]


if __name__ == '__main__':
    s = "leetcode"
    wordDict = ["leet", "code"]
    solution = Solution()

    result = solution.wordBreak(s, wordDict)
    print(result)
