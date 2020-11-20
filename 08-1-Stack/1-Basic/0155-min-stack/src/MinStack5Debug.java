import java.util.Stack;

public class MinStack5Debug {

    private Stack<Integer> data;
    private Stack<Integer> helper;

    public MinStack5Debug() {

        data = new Stack<>();
        helper = new Stack<>();
    }

    // 思路 2：辅助栈和数据栈不同步

    public void push(int x) {
        data.add(x);
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.add(x);
        }
        System.out.println("辅助栈：" + helper);
    }

    public void pop() {
        if (!data.isEmpty()) {

            System.out.println(String.format("data 栈顶 %s，helper 栈顶 %s，是否相等：%s", data.peek(), helper.peek(), data.peek() == helper.peek()));
            System.out.println();

            if (data.peek() == helper.peek()) {
                helper.pop();
            }
            data.pop();
        }
        System.out.println("辅助栈：" + helper);
    }

    public int top() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public int getMin() {
        if (!helper.isEmpty()) {
            return helper.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public static void main(String[] args) {
        MinStack5Debug minStack = new MinStack5Debug();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(515);

        minStack.pop();
        minStack.pop();
        minStack.pop();
    }
}
