class Trie:
    class Node:
        def __init__(self):
            self.is_word = False
            self.next = dict()

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = Trie.Node()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        cur_node = self.root

        for alpha in word:
            if alpha not in cur_node.next:
                cur_node.next[alpha] = Trie.Node()
            cur_node = cur_node.next[alpha]

        if not cur_node.is_word:
            cur_node.is_word = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        cur_node = self.root

        for alpha in word:
            if alpha not in cur_node.next:
                return False
            cur_node = cur_node.next[alpha]
        return cur_node.is_word

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        cur_node = self.root

        for alpha in prefix:
            if alpha not in cur_node.next:
                return False
            cur_node = cur_node.next[alpha]
        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
