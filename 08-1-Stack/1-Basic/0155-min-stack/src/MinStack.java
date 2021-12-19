import java.util.Stack;

public class MinStack {

    // 方法一：辅助栈和数据栈同步

    private Stack<Integer> data;
    private Stack<Integer> helper;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        data.add(x);
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.add(x);
        }else {
            helper.add(helper.peek());
        }
    }

    public void pop() {
        if (!data.isEmpty()) {
            data.pop();
            helper.pop();
        }
    }

    public int top() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        throw  new RuntimeException("栈为空");
    }

    public int getMin() {
        if (!data.isEmpty()) {
            return helper.peek();
        }
        throw  new RuntimeException("栈为空");
    }
}