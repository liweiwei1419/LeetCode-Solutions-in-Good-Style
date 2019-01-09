from collections import deque


class MyStack:

    # 用两个队列可以实现栈
    # 其实用一个也可以，但是就是每次 push 都要旋转一次

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # Python 中只有双端队列
        # 我们限制这个 双端队列 只能用 append （从右边加入）
        # 和 popleft （从左边弹出），就是普通的队列了
        self.queue1 = deque()
        self.queue2 = deque()

    def push(self, x):
        """
        Push element x onto stack.
        :type x: int
        :rtype: void
        """
        # 【关键】：push 的时候，你就使劲 push，就让它是个队列
        # 弹出的时候，会麻烦一些
        if self.queue1:
            self.queue1.append(x)
        else:
            self.queue2.append(x)

    def pop(self):
        """
        Removes the element on top of the stack and returns that element.
        :rtype: int
        """

        # 【关键】交换指针，这样我们可以把操作统一起来
        # 统一成 self.queue1 是那个非空的，主要的
        # self.queue2 是弹出的时候才用的
        if not self.queue1:
            self.queue1, self.queue2 = self.queue2, self.queue1
        # 注意，这里大于 1 很关键，最少是 2 个，弹出一个，剩下一个返回
        while len(self.queue1) > 1:
            self.queue2.append(self.queue1.popleft())
        return self.queue1.popleft()

    def top(self):
        """
        Get the top element.
        :rtype: int
        """
        # 这种问题真的是吃饱了撑的
        if not self.queue1:
            self.queue1, self.queue2 = self.queue2, self.queue1
        # 注意，这里大于 1 很关键，最少是 2 个，弹出一个，剩下一个返回
        while len(self.queue1) > 1:
            self.queue2.append(self.queue1.popleft())
        ret = self.queue1.popleft()
        self.queue2.append(ret)
        return ret

    def empty(self):
        """
        Returns whether the stack is empty.
        :rtype: bool
        """
        return not self.queue1 and not self.queue2


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()

if __name__ == '__main__':
    a = deque()
    a.append(1)
    a.append(2)
    a.append(3)
    a.appendleft(4)
    a.appendleft(5)
    a.appendleft(6)
    print(a)
