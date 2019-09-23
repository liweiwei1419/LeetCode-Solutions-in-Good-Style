class MapSum(object):
    # 设计成内部类，外部没有必要知道
    class TrieNode:
        def __init__(self):
            self.val = 0
            self.next = {}

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = MapSum.TrieNode()

    def insert(self, key: str, val: int) -> None:
        cur_node = self.root
        for c in key:
            if c not in cur_node.next.keys():
                cur_node.next[c] = MapSum.TrieNode()
            cur_node = cur_node.next[c]
        cur_node.val = val

    def sum(self, prefix: str) -> int:
        cur_node = self.root

        for c in prefix:
            if c in cur_node.next.keys():
                cur_node = cur_node.next[c]
            else:
                return 0
        return self.__sum(cur_node)

    # 这里用到了递归
    def __sum(self, node):
        res = node.val  # 这里不能初始化为 0
        for c in node.next.keys():
            res += self.__sum(node.next[c])
        return res

# Your MapSum object will be instantiated and called as such:
# obj = MapSum()
# obj.insert(key,val)
# param_2 = obj.sum(prefix)
