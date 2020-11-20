import java.util.Stack;

public class MinStack2 {

    // 方法二：辅助栈和数据栈不同步

    private Stack<Integer> data;
    private Stack<Integer> helper;

    /**
     * initialize your data structure here.
     */
    public MinStack2() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        data.add(x);
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.add(x);
        }
    }

    public void pop() {
        if (!data.isEmpty()) {
            int top = data.pop();
            if (top == helper.peek()) {
                helper.pop();
            }
        }
    }

    public int top() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        throw new RuntimeException("栈为空");
    }

    public int getMin() {
        if (!data.isEmpty()) {
            return helper.peek();
        }
        throw new RuntimeException("栈为空");
    }
}
