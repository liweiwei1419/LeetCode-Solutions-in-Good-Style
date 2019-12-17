import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    // 使用一个队列实现栈

    private Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.offer(x);
    }

    private void shift() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        shift();
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        shift();

        // 为了不打乱原来的 push 顺序，把这个元素再放到队尾
        // 如果队列长度很长，连着几次 top，会很耗时
        int res = queue.poll();
        queue.offer(res);
        return res;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */