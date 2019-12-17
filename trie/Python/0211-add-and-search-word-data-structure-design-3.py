class WordDictionary:
    class Node:
        def __init__(self):
            self.is_word = False
            self.next = [None for _ in range(26)]

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = WordDictionary.Node()

    def addWord(self, word: str) -> None:
        """
        Adds a word into the data structure.
        """
        size = len(word)
        cur_node = self.root
        for i in range(size):
            alpha = word[i]
            next = cur_node.next[ord(alpha) - ord('a')]
            if next is None:
                cur_node.next[ord(alpha) - ord('a')] = WordDictionary.Node()
            cur_node = cur_node.next[ord(alpha) - ord('a')]

        if not cur_node.is_word:
            cur_node.is_word = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
        """
        return self.__match(word, self.root, 0)

    def __match(self, word, node, start):
        if start == len(word):
            return node.is_word
        alpha = word[start]
        # 关键在这里，如果当前字母是 "." ，每一个分支都要走一遍
        if alpha == '.':
            # print(node.next)
            for i in range(26):
                if node.next[i] and self.__match(word, node.next[i], start + 1):
                    return True
            return False
        else:
            if not node.next[ord(alpha)-ord('a')]:
                return False
            return self.__match(word, node.next[ord(alpha) - ord('a')], start + 1)


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)


if __name__ == '__main__':
    wd = WordDictionary()
    wd.addWord("bad")
    wd.addWord("dad")
    wd.addWord("mad")

    # search("pad") -> false
    # search("bad") -> true
    # search(".ad") -> true
    # search("b..") -> true
    #

    res1 = wd.search("pad")
    res2 = wd.search("bad")
    res3 = wd.search(".ad")
    res4 = wd.search("b..")
    print(res1)
    print(res2)
    print(res3)
    print(res4)
