# 677. 键值映射
# 实现一个 MapSum 类里的两个方法，insert 和 sum。
# 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
# 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。


class MapSum(object):
    class Node:
        def __init__(self):
            self.val = 0
            self.dict = dict()

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = MapSum.Node()

    def insert(self, key: str, val: int) -> None:
        cur_node = self.root
        for alpha in key:
            if alpha not in cur_node.dict:
                cur_node.dict[alpha] = MapSum.Node()
            cur_node = cur_node.dict[alpha]
        cur_node.val = val

    def sum(self, prefix: str) -> int:
        cur_node = self.root
        for alpha in prefix:
            if alpha not in cur_node.dict:
                return 0
            cur_node = cur_node.dict[alpha]
        return self.presum(cur_node)

    def presum(self, node):
        """
        计算以 node 为根结点的所有字符串的和
        :param node:
        :return:
        """
        s = node.val
        for next in node.dict:
            s += self.presum(node.dict[next])
        return s

# Your MapSum object will be instantiated and called as such:
# obj = MapSum()
# obj.insert(key,val)
# param_2 = obj.sum(prefix)
