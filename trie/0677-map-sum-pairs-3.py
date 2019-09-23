class MapSum:
    class Node:
        def __init__(self):
            self.val = 0
            self.next = dict()

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = MapSum.Node()

    def insert(self, key: str, val: int) -> None:
        cur_node = self.root
        for alpha in key:
            if alpha not in cur_node.next:
                cur_node.next[alpha] = MapSum.Node()
            cur_node = cur_node.next[alpha]
        cur_node.val = val

    def sum(self, prefix: str) -> int:
        cur_node = self.root
        for pre in prefix:
            if pre not in cur_node.next:
                return 0
            cur_node = cur_node.next[pre]
        return self.__presum(cur_node)

    def __presum(self, node):
        s = node.val
        for next in node.next:
            s += self.__presum(node.next[next])
        return s

# Your MapSum object will be instantiated and called as such:
# obj = MapSum()
# obj.insert(key,val)
# param_2 = obj.sum(prefix)
