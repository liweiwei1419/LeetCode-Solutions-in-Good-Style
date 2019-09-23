from typing import List


class Node:
    def __init__(self, key, is_end=False):
        self.key = key
        self.children = {}
        self.is_end = is_end


class Trie:
    def __init__(self):
        self.root = Node('')
        self.root.is_end = True

    def insert(self, word):
        node = self.root
        for alpha in word:
            if alpha not in node.children:
                node.children[alpha] = Node(alpha)
            node = node.children[alpha]
        node.is_end = True


class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        for word in words:
            trie.insert(word)
        return ''.join(self.__get_word(trie.root))

    def __get_word(self, node):
        print(node.is_end)
        if not node.is_end:
            # is_end = False 的时候走到这里
            return []
        if not node.children:
            # 如果 children 是空的时候，走到这里
            return [node.key]
        # 叶子结点和根结点
        li = [self.__get_word(c) for c in node.children.values()]
        n = len(max(li, key=len))
        print(li)
        li = [i for i in li if len(i) == n]
        li.sort()
        print('debug', node.key, li)
        return [node.key] + li[0]


if __name__ == '__main__':
    words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
    solution = Solution()
    result = solution.longestWord(words)
    print(result)
