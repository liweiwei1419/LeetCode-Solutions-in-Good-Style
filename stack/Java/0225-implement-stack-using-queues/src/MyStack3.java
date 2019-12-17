import java.util.LinkedList;
import java.util.Queue;

public class MyStack3 {

    enum Operate {
        PUSH,
        POP,
        TOP
    }

    private Queue<Integer> queue;
    private Operate lastOperate;

    /**
     * Initialize your data structure here.
     */
    public MyStack3() {
        queue = new LinkedList<>();
        lastOperate = Operate.PUSH;
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (lastOperate == Operate.TOP) {
            queue.offer(queue.poll());
        }
        queue.offer(x);

        lastOperate = Operate.PUSH;
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
        if (lastOperate != Operate.TOP) {
            shift();
        }

        lastOperate = Operate.POP;
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (lastOperate == Operate.TOP) {
            return queue.peek();
        }
        shift();
        lastOperate = Operate.TOP;
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
