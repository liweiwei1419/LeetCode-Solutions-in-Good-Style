import java.util.Stack;

/**
 * @author liweiwei1419
 * @date 2019/11/2 9:42 上午
 */
public class Solution4 {

    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        if (len == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int a;
        int b;
        String operators = "+-*/";
        int c;
        for (int i = 0; i < len; i++) {
            if (operators.contains(tokens[i])) {
                a = stack.pop();
                b = stack.pop();
                switch (tokens[i]) {
                    case "+":
                        c = b + a;
                        break;
                    case "-":
                        c = b - a;
                        break;
                    case "*":
                        c = b * a;
                        break;
                    case "/":
                        c = b / a;
                        break;
                    default:
                        // 无意义
                        c = 0;
                }
                stack.push(c);
            } else {
                // 是数字
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }
}
