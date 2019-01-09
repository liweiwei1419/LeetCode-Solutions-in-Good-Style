# 208. 实现 Trie (前缀树)


class Trie(object):
    class Node:
        def __init__(self):
            self.is_word = False
            self.dict = dict()

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = Trie.Node()

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: void
        """
        cur_node = self.root
        for alpha in word:
            if alpha not in cur_node.dict:
                cur_node.dict[alpha] = Trie.Node()
            # 这里不要写成 else ，那就大错特错了
            cur_node = cur_node.dict[alpha]
        if not cur_node.is_word:
            cur_node.is_word = True

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        cur_node = self.root
        for alpha in word:
            if alpha not in cur_node.dict:
                return False
            else:
                cur_node = cur_node.dict[alpha]
        return cur_node.is_word

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        cur_node = self.root
        for alpha in prefix:
            if alpha not in cur_node.dict:
                return False
            else:
                cur_node = cur_node.dict[alpha]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)

if __name__ == '__main__':
    trie = Trie()
    trie.insert("apple")

    search1 = trie.search("apple")  # 返回 true
    print(search1)

    # System.out.println(search1);
    # boolean
    # search2 = trie.search("app"); // 返回
    # false
    # System.out.println(search2);
    # boolean
    # startsWith = trie.startsWith("app"); // 返回
    # true
    # System.out.println(startsWith);
    # trie.insert("app");
    # boolean
    # search3 = trie.search("app"); // 返回
    # true
    # System.out.println(search3);
