import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {

    private Deque<Integer> pushStack;
    private Deque<Integer> popStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        pushStack = new ArrayDeque<>();
        popStack = new ArrayDeque<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        // 在任何时候都可以向 pushStack 推入元素
        pushStack.addLast(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        // 从 popStack 取出元素
        if (!popStack.isEmpty()) {
            return popStack.removeLast();
        }
        // 走到这里是因为 popStack 为空，此时需要将 pushStack 里的所有元素依次放入 popStack
        while (!pushStack.isEmpty()) {
            popStack.addLast(pushStack.removeLast());
        }
        return popStack.removeLast();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        // 从 popStack 取出元素
        if (!popStack.isEmpty()) {
            return popStack.peekLast();
        }
        // 走到这里是因为 popStack 为空，此时需要将 pushStack 里的所有元素依次放入 popStack
        while (!pushStack.isEmpty()) {
            popStack.addLast(pushStack.removeLast());
        }
        return popStack.peekLast();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        // 两个栈都为空，才说明队列为空
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */