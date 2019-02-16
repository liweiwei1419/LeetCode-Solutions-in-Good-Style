class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.data = []
        self.help = []

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        self.data.append(x)
        if len(self.help) == 0:
            self.help.append(x)
        else:
            if self.help[-1] <= x:
                self.help.append(self.help[-1])
            else:
                self.help.append(x)

    def pop(self):
        """
        :rtype: void
        """
        if self.data:
            self.help.pop()
            return self.data.pop()

    def top(self):
        """
        :rtype: int
        """
        if self.data:
            return self.data[-1]

    def getMin(self):
        """
        :rtype: int
        """
        if self.help:
            return self.help[-1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()