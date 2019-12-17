import java.util.LinkedList;
import java.util.Queue;

public class MyStack2 {

    /**
     * 使用两个队列实现栈（完全可以只用一个栈）
     * queue1 是主要的队列，queue2 只是辅助
     */
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    /**
     * Initialize your data structure here.
     */
    public MyStack2() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue1.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        shift();
        return queue2.poll();
    }

    private void shift() {
        int size = queue1.size();
        for (int i = 0; i < size - 1; i++) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /**
     * Get the top element.
     */
    public int top() {
        shift();
        int res = queue2.poll();
        queue1.offer(res);
        return res;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
