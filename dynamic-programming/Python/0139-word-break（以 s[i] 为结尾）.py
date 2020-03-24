from typing import List


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        size = len(s)
        # 题目中说非空字符串，以下 assert 一定通过
        assert size > 0

        # 预处理，把 wordDict 放进一个哈希表中
        word_set = {word for word in wordDict}
        # print(word_set)

        # 这种状态定义很常见
        dp = [False for _ in range(size)]

        dp[0] = s[0] in word_set

        # 使用 r 表示右边界，可以取到
        # 使用 l 表示左边界，也可以取到
        for r in range(1, size):
            # Python 的语法，在切片的时候不包括右边界
            # 如果整个单词就直接在 word_set 中，直接返回就好了
            # 否则把单词做分割，挨个去判断
            if s[:r + 1] in word_set:
                dp[r] = True
                continue

            for l in range(r):
                # dp[l] 写在前面会更快一点，否则还要去切片，然后再放入 hash 表判重
                if dp[l] and s[l + 1: r + 1] in word_set:
                    dp[r] = True
                    # 这个 break 很重要，一旦得到 dp[r] = True ，循环不必再继续
                    break
        return dp[-1]


if __name__ == '__main__':
    s = "leetcode"
    wordDict = ["leet", "code"]
    solution = Solution()
    res = solution.wordBreak(s, wordDict)
    print(res)
