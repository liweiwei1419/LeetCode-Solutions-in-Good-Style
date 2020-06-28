class MaxQueue(object):
    def __init__(self):
        from collections import deque
        self.que = deque()
        self.sort_que = deque()

    def max_value(self):
        """
        :rtype: int
        """
        print(self.sort_que)

        return self.sort_que[0] if self.sort_que else -1

    def push_back(self, value):
        """
        :type value: int
        :rtype: None
        """
        self.que.append(value)
        while self.sort_que and self.sort_que[-1] < value:
            self.sort_que.pop()
        self.sort_que.append(value)

    def pop_front(self):
        """
        :rtype: int
        """
        if not self.que: return -1
        res = self.que.popleft()
        if res == self.sort_que[0]:
            self.sort_que.popleft()
        return res


if __name__ == '__main__':
    max_queue = MaxQueue()
    max_queue.push_back(-55)
    max_queue.push_back(2)
    res1 = max_queue.max_value()
    print(res1)

    max_queue.push_back(3)
    res2 = max_queue.max_value()
    print(res2)

    max_queue.push_back(1)
    res3 = max_queue.max_value()
    print(res3)

    max_queue.push_back(6)
    max_queue.pop_front()

    res4 = max_queue.max_value()
    print(res4)

    max_queue.push_back(11)
    max_queue.pop_front()

    res5 = max_queue.max_value()
    print(res5)
