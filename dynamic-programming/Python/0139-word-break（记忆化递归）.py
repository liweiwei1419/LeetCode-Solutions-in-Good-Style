from typing import List


class Solution:

    def __init__(self):
        self.memo_ = dict()

    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        # 题目说了 s 非空，wordDict 非空
        word_set = set(wordDict)
        return self.__word_break(s, word_set)

    def __word_break(self, s, word_set):

        # 首先看缓存
        if s in self.memo_:
            return self.memo_[s]

        # 特判
        if s in word_set:
            self.memo_[s] = True
            return True

        res = False

        for j in range(1, len(s)):

            left = s[:j]
            right = s[j:len(s)]

            # 注意：不要把 self.__word_break(left, word_set) 这一个判断放在前面
            # 否则会发生死循环，如果在代码编写过程中出现死循环，不要着急，debug 一下
            # 很快就会找到原因的
            if right in word_set and self.__word_break(left, word_set):
                res = True
                break
        self.memo_[s] = res
        return res


if __name__ == '__main__':
    solution = Solution()
    s = "leetcode"
    wordDict = ["leet", "code"]

    result = solution.wordBreak(s, wordDict)
    print(result)
