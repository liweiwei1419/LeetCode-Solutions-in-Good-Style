from collections import deque


# 双端队列

class NestedIterator(object):

    def __init__(self, nestedList):
        """
        Initialize your data structure here.
        :type nestedList: List[NestedInteger]
        """

        self.stack = deque(nestedList[::-1])
        # 临时存放变量的地方，如果被取出，就清空
        # 如果只是查看，不清空
        self.value = None

    def next(self):
        """
        :rtype: int
        """

        self.hasNext()
        ret = self.value
        self.value = None
        return ret

    def hasNext(self):
        """
        :rtype: bool
        """

        # 特别注意：这里如果 self.value == 0 为 True，也不会执行这个方法的
        if self.value is not None:
            return True

        stack = self.stack
        while stack:
            top = stack.pop()
            if top.isInteger():
                self.value = top.getInteger()
                return True
            else:
                stack.extend(top.getList()[::-1])
        return False


# Your NestedIterator object will be instantiated and called as such:
# i, v = NestedIterator(nestedList), []
# while i.hasNext(): v.append(i.next())

if __name__ == '__main__':

    a = None
    if a:
        print('hello')
