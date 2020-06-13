import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class MyQueue {

    private Deque<Integer> stackPush;
    private Deque<Integer> stackPop;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stackPush = new ArrayDeque<>();
        stackPop = new ArrayDeque<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stackPush.addLast(x);
    }

    /**
     * 辅助方法：一次性将 stackPush 里的所有元素倒入 stackPop
     * 注意：1、该操作只在 stackPop 里为空的时候才操作，否则会破坏出队入队的顺序
     * 2、在 peek 和 pop 操作之前调用该方法
     */
    private void shift() {
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.addLast(stackPush.removeLast());
            }
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        shift();
        if (!stackPop.isEmpty()) {
            return stackPop.removeLast();
        }
        throw new RuntimeException("队列里没有元素");
    }

    /**
     * Get the front element.
     */
    public int peek() {
        shift();
        if (!stackPop.isEmpty()) {
            return stackPop.peekLast();
        }
        throw new RuntimeException("队列里没有元素");
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stackPush.isEmpty() && stackPop.isEmpty();
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