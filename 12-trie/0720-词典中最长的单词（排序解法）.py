class Solution:

    # 参考资料：https://blog.csdn.net/fuxuemingzhu/article/details/79123277?utm_source=blogxgwz6

    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        # 放到 set 里面，重复的去掉了，而且可以很快查到前缀是否有
        # 字典树效果更好
        word_set = set(words)
        res = ''
        for word in words:
            # 默认有，只要有一个没有，就可以退出循环了
            has_pre = True
            for i in range(1, len(word)):
                if word[:i] not in word_set:
                    has_pre = False
                    break
            if has_pre:
                if not res or len(word) > len(res):
                    res = word
                elif len(word) == len(res) and res > word:
                    res = word
        return res


if __name__ == '__main__':
    words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
    solution = Solution()
    result = solution.longestWord(words)
    print(result)
