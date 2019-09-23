# 211. 添加与搜索单词 - 数据结构设计
# 要能支持正则表达式

# 设计一个支持以下两种操作的数据结构：
#
# void addWord(word)
# bool search(word)
# search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。


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
        # 注意：这里要设置辅助函数
        return self.match(self.root, word, 0)

    def match(self, node, word, index):
        if index == len(word):
            return node.is_word
        alpha = word[index]
        if alpha == '.':
            for next in node.next:
                if self.match(node.next[next], word, index + 1):
                    return True
            # 注意：这里要返回
            return False
        else:
            # 注意：这里要使用 else
            if alpha not in node.next:
                return False
            # 注意：这里要使用 return 返回
            return self.match(node.next[alpha], word, index + 1)


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)

if __name__ == '__main__':
    print('.' == '.')
