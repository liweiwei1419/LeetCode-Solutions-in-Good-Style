class MinStack(object):

    # 辅助栈和数据栈同步
    # 思路简单不容易出错

    def __init__(self):
        # 数据栈
        self.data = []
        # 辅助栈
        self.helper = []

    def push(self, x):
        self.data.append(x)
        if len(self.helper) == 0 or x < self.helper[-1]:
            self.helper.append(x)
        else:
            self.helper.append(self.helper[-1])

    def pop(self):
        if len(self.data) > 0:
            ret = self.data.pop()
            self.helper.pop()
            return ret

    def top(self):
        if len(self.data) > 0:
            return self.data[-1]

    def getMin(self):
        if len(self.data) > 0:
            return self.helper[-1]


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
