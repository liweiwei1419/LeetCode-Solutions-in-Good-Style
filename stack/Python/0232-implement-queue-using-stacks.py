class MyQueue(object):

    # 关键：stack1 是主栈
    # stack2 永远是辅助

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1 = []
        self.stack2 = []

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: void
        """
        self.stack1.append(x)

    def __shift_stacks(self):
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        self.__shift_stacks()
        return self.stack2.pop()

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """

        self.__shift_stacks()
        return self.stack2[-1]

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        return not self.stack1 and not self.stack2

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
