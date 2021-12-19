import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    // 思路：数字就加入栈，运算符就计算

    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        if (len == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        // 第 2 个数
        int a;
        // 第 1 个数
        int b;
        int c = 0;
        String operators = "+-*/";
        for (int i = 0; i < len; i++) {
            // 是运算符，问题 contains 这个方法好不好？
            if (operators.contains(tokens[i])) {
                // 第 2 个数
                a = stack.removeLast();
                // 第 1 个数
                b = stack.removeLast();
                if ("+".equals(tokens[i])) {
                    c = b + a;
                }
                if ("-".equals(tokens[i])) {
                    c = b - a;
                }
                if ("*".equals(tokens[i])) {
                    c = b * a;
                }
                if ("/".equals(tokens[i])) {
                    c = b / a;
                }
                stack.addLast(c);
            } else {
                // 是数字
                stack.addLast(Integer.parseInt(tokens[i]));
            }
        }
        return stack.removeLast();
    }
}