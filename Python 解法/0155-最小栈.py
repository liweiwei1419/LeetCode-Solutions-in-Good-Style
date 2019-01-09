class MinStack(object):

    # 【特别注意】数据栈和辅助栈要同步，特殊测试用例为：
    # 依次 push 0 1 0，马上弹栈，查询最小

    def __init__(self):
        """
        initialize your data structure here.
        """
        # 数据栈
        self.data_stack = []
        # 辅助栈
        self.help_stack = []

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        self.data_stack.append(x)
        if len(self.help_stack) == 0 or x < self.help_stack[-1]:
            self.help_stack.append(x)
        else:
            self.help_stack.append(self.help_stack[-1])

    def pop(self):
        """
        :rtype: void
        """
        if len(self.data_stack) > 0:
            ret = self.data_stack.pop()
            self.help_stack.pop()
            return ret

    def top(self):
        """
        :rtype: int
        """
        if len(self.data_stack) > 0:
            return self.data_stack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        if len(self.data_stack) > 0:
            return self.help_stack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
if __name__ == '__main__':
    min_stack = MinStack()
    min_stack.push(0)
    min_stack.push(1)
    min_stack.push(0)
    print(min_stack.getMin())
    min_stack.pop()
    print(min_stack)

    print(min_stack.getMin())
