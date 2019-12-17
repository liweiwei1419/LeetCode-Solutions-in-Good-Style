import java.util.Stack;

public class MyQueue2 {

    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    private State lastState;

    enum State {
        /**
         *  上一次的操作：有元素入队
         */
        PUSH,
        /**
         * 上一次的操作：有元素出队
         */
        POP
    }

    /**
     * Initialize your data structure here.
     */
    public MyQueue2() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
        lastState = State.PUSH;
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (lastState == State.PUSH) {
            stackPush.push(x);
        } else {
            // 如果是刚刚 POP 完的话
            while (!stackPop.empty()) {
                stackPush.push(stackPop.pop());
            }
            stackPush.push(x);
            lastState = State.PUSH;
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (lastState == State.POP) {
            if (stackPop.empty()) {
                throw new IllegalArgumentException("queue is empty");
            }
            return stackPop.pop();
        } else {
            // 如果是刚刚 PUSH 完的话
            while (!stackPush.empty()) {
                stackPop.add(stackPush.pop());
            }
            lastState = State.POP;
            return stackPop.pop();
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (lastState == State.POP) {
            if (stackPop.empty()) {
                throw new IllegalArgumentException("queue is empty");
            }
            return stackPop.peek();
        } else {
            // 如果是刚刚 PUSH 完的话
            while (!stackPush.empty()) {
                stackPop.add(stackPush.pop());
            }
            lastState = State.POP;
            return stackPop.peek();
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stackPush.empty() && stackPop.empty();
    }
}
