class WordDictionary:
    class Node:
        def __init__(self):
            self.is_word = False
            self.next = dict()

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = WordDictionary.Node()

    def addWord(self, word: str) -> None:
        """
        Adds a word into the data structure.
        """
        cur_node = self.root
        for alpha in word:
            if alpha not in cur_node.next:
                cur_node.next[alpha] = WordDictionary.Node()
            cur_node = cur_node.next[alpha]
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
            for next in node.next:
                if self.__match(word, node.next[next], start + 1):
                    return True
            return False
        else:
            if not alpha in node.next:
                return False
            return self.__match(word, node.next[alpha], start + 1)

# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)
