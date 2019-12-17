import java.util.Stack;

/**
 * @author liweiwei1419
 * @date 2019/9/20 11:04 下午
 */
public class Solution {

    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        if (len == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        // 第 2 个数
        int a;
        // 第 1 个数
        int b;
        int c = 0;
        String operators = "+-*/";
        for (int i = 0; i < len; i++) {
            // 是运算符
            if (operators.contains(tokens[i])) {
                // 第 2 个数
                a = stack.pop();
                // 第 1 个数
                b = stack.pop();
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
                stack.push(c);
            } else {
                // 是数字
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int res = new Solution().evalRPN(tokens);
        System.out.println(res);
    }
}
