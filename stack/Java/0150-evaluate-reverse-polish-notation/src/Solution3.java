import java.util.Stack;

/**
 * Created by liwei on 17/9/15.
 */
public class Solution3 {

    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        String pattern = "-?[0-9]+|[\\+\\-\\*/]";

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            String token = tokens[i];
            if (!token.matches(pattern)) {
                throw new RuntimeException("非法的表达式");
            }
            if (token.matches("-?[0-9]+")) {
                int num = Integer.valueOf(token);
                stack.push(num);
            }
            if (token.matches("[\\+\\-\\*/]")) {
                if (stack.size() >= 2) {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    int result = 0;
                    switch (token) {
                        case "+":
                            result = num2 + num1;
                            break;
                        case "-":
                            result = num2 - num1;
                            break;
                        case "*":
                            result = num2 * num1;
                            break;
                        case "/":
                            result = num2 / num1;
                            break;
                        default:
                            break;
                    }
                    stack.push(result);
                }
            }
        }
        return stack.pop();
    }
}
