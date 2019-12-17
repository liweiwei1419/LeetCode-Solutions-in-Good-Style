import java.util.Stack;

public class Solution2 {

    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        if (len == 1) {
            return Integer.parseInt(tokens[0]);
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            String token = tokens[i];
            if (token.matches("^-?\\d+$")) {
                // 整数
                int num = Integer.parseInt(token);
                stack.push(num);
            } else {
                // token.matches("[\\+\\-\\*/]"
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

                }
                stack.push(result);
            }
        }
        return stack.pop();
    }
}

